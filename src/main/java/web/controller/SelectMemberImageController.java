package web.controller;

import static core.util.CommonUtil.json2Pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import web.dao.imp.MemberDaoImpl;
import web.service.MemberService;
import web.service.imp.MemberServiceImpl;
import web.vo.MemberVo;

@WebServlet("/web/controller/SelectMemberImageController")
public class SelectMemberImageController extends HttpServlet {

	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setContentType("image/jpg");
		
		Integer member_id = Integer.parseInt(req.getParameter("member_id"));
		
//		MemberVo memberVo = json2Pojo(req, MemberVo.class);
//		List<byte[]> imageList = new ArrayList<>(); // 建立byte[]的list
//
//		for (Part part : req.getParts()) { // 圖片們是用request.getParts()取 forEach迴圈來對每個Part做處理
//			if (part.getName().startsWith("images")) { // 這裡images就是前端設的key
//				try (InputStream inputStream = part.getInputStream()) { // 這裡用到trywithresources寫法 讓IS自動關閉
//					imageList.add(inputStream.readAllBytes()); // 用IS的readAllBytes()加到list裡
//				} catch (IOException e) {
//					e.printStackTrace(); // 處理Exception
//				}
//			}
//		}
		
		MemberVo   membervo   =new MemberDaoImpl().selectMemberImgById(member_id);	
		
		resp.getOutputStream().write(membervo.getProfilePicture());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doPost(req, resp);
		
	}
}
