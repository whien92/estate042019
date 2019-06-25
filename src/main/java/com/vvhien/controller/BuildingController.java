 package com.vvhien.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.service.IBuildingService;
import com.vvhien.service.impl.BuildingService;
import com.vvhien.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;
	
	private IBuildingService buildingService;
	
	public BuildingController() {
		buildingService = new BuildingService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BuildingDTO model = FormUtil.toModel(BuildingDTO.class, req);
		String action = req.getParameter("action");
		String url = "";

		if(action.equals("LIST")) {
			req.setAttribute("buildings", "");
			url = "/views/building/list.jsp";
			
			//req.setAttribute("buildings", buildingService.findAll(builder, pageble));
			model.setListResults(buildingService.findAll(builder, pageble));
		}
		else if(action.equals("EDIT")) {
			url = "/views/building/edit.jsp";
		}
		
		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
