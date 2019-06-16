 package com.vvhien.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String url = "";

		if(action.equals("LIST")) {
			req.setAttribute("buildings", "");
			url = "/views/building/list.jsp";
		}
		else if(action.equals("EDIT")) {
			url = "/views/building/edit.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
