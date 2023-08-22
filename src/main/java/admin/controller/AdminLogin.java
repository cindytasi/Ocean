package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.service.AdminService;
import admin.service.impl.AdminServiceImpl;
import admin.vo.AdminVo;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{
	private AdminService as;
	@Override
	public void init() throws ServletException {
		as = new AdminServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("account");
        String password = req.getParameter("password");
        
        AdminVo avo = new AdminVo();
        avo.setAdminAccount(account);
        avo.setAdminPassword(password);
        
        AdminVo check = as.checkLogin(avo);
        if(check==null) {
        	resp.getWriter().write("帳號或密碼不正確!");
        }else {
        	HttpSession session = req.getSession();
        	session.setAttribute("adminName", avo.getAdminName());
        	resp.sendRedirect("/Ocean/admin/admin.html");
        }
	}

	
}
