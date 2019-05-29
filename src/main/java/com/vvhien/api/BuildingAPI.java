   package com.vvhien.api;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.repository.IBuildingRepository;
import com.vvhien.repository.impl.BuildingRepository;
import com.vvhien.service.IBuildingService;
import com.vvhien.service.impl.BuildingService;
import com.vvhien.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-building"})
public class BuildingAPI extends HttpServlet{
	private static final long serialVersionUID = 6481020526414564578L;
	
	private IBuildingService buildingService;
	
	public BuildingAPI() {
		buildingService = new BuildingService();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BuildingDTO buildingDTO =  HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingDTO = buildingService.save(buildingDTO);
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BuildingDTO buildingDTO =  HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.update(buildingDTO);
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BuildingDTO buildingDTO =  HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.delete(buildingDTO.getId());
		objectMapper.writeValue(resp.getOutputStream(), buildingDTO);
	}

}
