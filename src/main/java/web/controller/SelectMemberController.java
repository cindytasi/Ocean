package web.controller;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;

import web.service.MemberService;
import web.service.imp.MemberServiceImpl;
import web.vo.MemberVo;
import web.vo.UserVo;

@WebServlet("/web/controller/SelectMemberController")
public class SelectMemberController extends HttpServlet {

	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("SelectMemberController");
		MemberVo memberVo = json2Pojo(req, MemberVo.class);
		System.out.println(memberVo.getUserId());

		List<MemberVo> memberVos = memberService.selectMember(memberVo);

		
		writePojo2Json(resp, memberVos);
	}
}
