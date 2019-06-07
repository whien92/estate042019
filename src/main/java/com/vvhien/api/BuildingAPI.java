package com.vvhien.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.service.IBuildingService;
import com.vvhien.service.impl.BuildingService;
import com.vvhien.utils.HttpUtil;

import paging.PageRequest;
import paging.Pageble;
import paging.Sorter;

@WebServlet(urlPatterns = { "/api-admin-building" })
public class BuildingAPI extends HttpServlet {
	private static final long serialVersionUID = 6481020526414564578L;

	private IBuildingService buildingService;

	public BuildingAPI() {
		buildingService = new BuildingService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map m = req.getParameterMap();
		Set s = m.entrySet();
		Iterator it = s.iterator();


		int sizeOfParams = m.size();
		Long id = null;
		
		if(m.containsKey("id")) {
			id = Long.valueOf(req.getParameter("id"));
		}

		if (sizeOfParams == 0) {
			// do getAllBuildings
			Map<String, Object> properties = new HashedMap();
			properties.put("name", "TMA");
			properties.put("buildingarea", 1000);
			
			Sorter sorter = new Sorter("numberofbasement", "desc");
			
			Pageble pageble = new PageRequest(1, 2, sorter);
			
			Object[] where = null;
			
			List<BuildingDTO> buildingDTOs = buildingService.findAll(properties, pageble, where);
			
			for (int i = 0; i < buildingDTOs.size(); i++) {
				System.out.println(buildingDTOs.get(i));
			}
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			objectMapper.writeValue(resp.getOutputStream(), buildingDTOs);
			
		} else if (sizeOfParams == 1 && id != null) {
			// do findById
			ObjectMapper objectMapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			BuildingDTO buildingDTO = buildingService.findById1(id);
			objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
		} else {
			// do FindBy
			ObjectMapper objectMapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			List<BuildingDTO> listOfBuildingDTO = buildingService.findBy(it);
			objectMapper.writeValue(resp.getOutputStream(), listOfBuildingDTO);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingDTO = buildingService.save(buildingDTO);
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.update(buildingDTO);
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.delete(buildingDTO.getId());
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}

	public static void main(String[] args) {

	}

}
