package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShohinBean;
import service.ShohinService;

public class ShoppingController extends HttpServlet{
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        try {
	            ArrayList<ShohinBean> shohinBean = ShohinService.search();
	            request.setAttribute("shohinBean", shohinBean);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/itemindex.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
}
