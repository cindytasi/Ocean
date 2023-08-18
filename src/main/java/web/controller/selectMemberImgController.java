package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MemberService;
import web.vo.MemberVo;

@WebServlet("/web/controller/selectMemberImgController")
public class selectMemberImgController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setContentType("application/json; charset=utf-8");

        resp.setContentType("image/jpg");
        
        Integer memid =Integer.parseInt(req.getParameter("memberId"));
        
        MemberVo memberVo = memberService.selectMemberImg(memid);
        
        resp.getOutputStream().write(memberVo.getProfilePicture());
        
        resp.getOutputStream().flush();
	}
	

	
}
