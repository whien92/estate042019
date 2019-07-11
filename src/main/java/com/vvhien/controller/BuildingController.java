 package com.vvhien.controller;


import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.paging.PageRequest;
import com.vvhien.paging.Pageble;
import com.vvhien.service.IBuildingService;
import com.vvhien.utils.DataUtils;
import com.vvhien.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private IBuildingService buildingService;
	
	/*public BuildingController() {
		if(buildingService == null) {
			buildingService = new BuildingService();
		}
	}*/
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BuildingDTO model = FormUtil.toModel(BuildingDTO.class, req);
		String action = req.getParameter("action");
		String url = "";

		if(action.equals("LIST")) {
			req.setAttribute("buildings", "");
			url = "/views/building/list.jsp";
			
			Pageble pageble = new PageRequest(null, null, null);
			BuildingSearchBuilder builder = initBuildingBulder(model);
			model.setListResults(buildingService.findAll(builder, pageble));
		}
		else if(action.equals("EDIT")) {
			url = "/views/building/edit.jsp";
		}
		
		req.setAttribute("districts", DataUtils.getDistricts());
		req.setAttribute("buildingTypes", DataUtils.getBuildingTypes());
		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	private BuildingSearchBuilder initBuildingBulder(BuildingDTO model) {
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(model.getName())
				.setWard(model.getWard())
				.setStreet(model.getStreet())
				.setDistrict(model.getDistrict())
				.setNumberOfBasement(model.getNumberOfBasement())
				.setBuildingArea(model.getBuildingArea())
				.setCostRentFrom(model.getCostRentFrom())
				.setCostRentTo(model.getCostRentTo())
				.setAreaRentFrom(model.getAreaRentFrom())
				.setAreaRentTo(model.getAreaRentTo())
				.setBuildingTypes(model.getBuildingTypes())
				.build();
		return builder;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
