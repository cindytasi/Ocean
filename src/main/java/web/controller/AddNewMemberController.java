package web.controller;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.vo.CoreVo;
import web.service.MemberService;
import web.service.UserService;
import web.service.imp.MemberServiceImpl;
import web.service.imp.UserServiceImpl;
import web.vo.MemberVo;
import web.vo.UserVo;

@WebServlet("/web/controller/AddNewMemberController")
public class AddNewMemberController extends HttpServlet {

	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AddNewMemberController");
		MemberVo memberVo = json2Pojo(req, MemberVo.class);
		CoreVo coreVo = new CoreVo();
		

		memberVo = memberService.addNewMember(memberVo);
//		System.out.println(memberVo.getMemberName());
//		System.out.println(memberVo.getChildMember());
//		System.out.println(memberVo.getMemberPassword());
//		System.out.println(memberVo.getUserId());
		
		
		writePojo2Json(resp, memberVo);
	}
}
