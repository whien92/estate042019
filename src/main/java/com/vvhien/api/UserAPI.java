package com.vvhien.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.dto.UserDTO;
import com.vvhien.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet{
	private static final long serialVersionUID = 6481020526414564578L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		UserDTO userDTO =  HttpUtil.of(req.getReader()).toModel(UserDTO.class);
		System.out.println("userDTO " + userDTO);
		
		objectMapper.writeValue(resp.getOutputStream(), userDTO);
	}

}
