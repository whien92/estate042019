package com.vvhien.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.vvhien.annotation.Column;
import com.vvhien.annotation.Table;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.mapper.ResultSetMapper;
import com.vvhien.repository.GenericJDBC;

public class AbstractJDBC<T> implements GenericJDBC<T> {
	
	private Class<T> zClass;
	private ModelMapper modelMapper;
	
	@SuppressWarnings("unchecked")
	public AbstractJDBC() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	private Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/estate042019";
		String username = "root";
		String password = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List query(String sql, Object... parameters) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			if (con != null) {
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					ps.setObject(index, parameters[i]);
				}
				return resultSetMapper.mapRow(rs, zClass);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (con != null) {
				// set parameter to statement ps
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					ps.setObject(index, parameters[i]);
				}
				int rowsInserted = ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				con.commit();
				if (rowsInserted > 0) {
					while (rs.next()) {
						Long id = rs.getLong(1);
						return id;
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error: " + e1.getMessage());
				}
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (con != null) {
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					ps.setObject(index, parameters[i]);
				}
				ps.executeUpdate();
				con.commit();
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error: " + e1.getMessage());
				}
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
	}

	@Override
	public Long insert(Object object) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);

			String sql = createSQLInsert();

			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (con != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					ps.setObject(index, field.get(object));
				}

				Class<?> parentClass = zClass.getSuperclass();

				int indexParent = fields.length + 1;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						System.out.println("indexParent " + indexParent + " field.get(object) " + field.get(object));
						ps.setObject(indexParent, field.get(object));
						indexParent = indexParent + 1;
					}
					parentClass = parentClass.getSuperclass();
				}
				int rowsInserted = ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				con.commit();
				if (rowsInserted > 0) {
					while (rs.next()) {
						Long id = rs.getLong(1);
						return id;
					}
				}
			}
		} catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			System.out.println("Error: " + e.getMessage());
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error: " + e1.getMessage());
				}
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
		return null;
	}

	private String createSQLInsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");

		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "INSERT INTO " + tableName + "(" + fields.toString() + ") VALUES(" + params.toString() + ")";
		return sql;
	}

	@Override
	public void update(Object object) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String sql = createSQLUpdate();
			ps = con.prepareStatement(sql);
			
			if (con != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();
				
				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					System.out.println("index " + index + " field.get(object) " + field.getName() + " " + field.get(object));
					ps.setObject(index, field.get(object));
				}

				Class<?> parentClass = zClass.getSuperclass();

				int indexParent = fields.length + 1;
				Object id = null;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						String name = field.getName();
						if(!name.equals("id")) {
							System.out.println("indexParent " + indexParent + " field.get(object) " + field.getName() + " " + field.get(object));
							ps.setObject(indexParent, field.get(object));
							indexParent = indexParent + 1;
						}
						else {
							id = field.get(object);
						}
					}
					parentClass = parentClass.getSuperclass();
				}
				ps.setObject(indexParent, id);
				indexParent = indexParent + 1;
				ps.executeUpdate();
				con.commit();
			}
		} catch (SQLException  | IllegalArgumentException | IllegalAccessException e) {
			System.out.println("Error: " + e.getMessage());
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error: " + e1.getMessage());
				}
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
	}

	private String createSQLUpdate() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder sets = new StringBuilder("");
		String where = " WHERE ";

		for (Field field : zClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				String columnName =  column.name();
				String value = columnName + " = ? ";
				if(!columnName.equals("id")) {
					if (sets.length() > 1) {
						sets.append(", ");
					}
					sets.append(value);
				}
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					String columnName =  column.name();
					String value = columnName + " = ? ";
					if(!columnName.equals("id")) {
						if (sets.length() > 1) {
							sets.append(", ");
						}
						sets.append(value);
					}
					else {
						where = where + value;
					}
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "UPDATE " + tableName + " SET " + sets.toString() + where;
		return sql;
	}

	@Override
	public void delete(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String sql = createSQLDelete();
			System.out.println("Sql delete: " + sql);
			ps = con.prepareStatement(sql);
			
			if (con != null) {
				ps.setObject(1, id);
				ps.executeUpdate();
				con.commit();
			}
		} catch (SQLException  | IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error: " + e1.getMessage());
				}
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
	}

	private String createSQLDelete() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "DELETE FROM " + tableName + " WHERE id = ?";
		return sql;
	}

	@Override
	public BuildingDTO findById(Long id) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		List results = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String sql = createSQLFindById(id);
			ps = con.prepareStatement(sql);
			
			if (con != null) {
				ps.setObject(1, id);
				rs = ps.executeQuery();
				con.commit();
				results = resultSetMapper.mapRow(rs, zClass);
				return modelMapper.map(results.get(0), BuildingDTO.class);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;	
	}

	private String createSQLFindById(Long id) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
		return sql;
	}

}
