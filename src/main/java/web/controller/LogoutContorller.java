package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.UserService;
import web.service.imp.UserServiceImpl;

@WebServlet("/web/controller/LogoutContorller")
public class LogoutContorller extends HttpServlet{


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
	}
}
