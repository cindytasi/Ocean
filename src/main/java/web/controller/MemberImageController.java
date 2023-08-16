package web.controller;

import static core.util.CommonUtil.writePojo2Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import web.service.MemberService;
import web.service.UserService;
import web.service.imp.MemberServiceImpl;
import web.service.imp.UserServiceImpl;
import web.vo.MemberVo;

@WebServlet("/web/controller/MemberImageController")
@MultipartConfig
public class MemberImageController extends HttpServlet {

	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberName = getPartValue(req.getPart("memberName"));
		String memberPassword = getPartValue(req.getPart("memberPassword"));
		String childMember = getPartValue(req.getPart("childMember"));
		String userId = getPartValue(req.getPart("userId"));
		Part profilePicture = req.getPart("profilePicture");
		memberService.memberImage(profilePicture);

//		System.out.println(memberName);
//		System.out.println(memberPassword);
//		System.out.println(childMember);
//		System.out.println(profilePicture);

		MemberVo memberVo = new MemberVo();
		memberVo.setMemberName(memberName);
		memberVo.setMemberPassword(memberPassword);
		memberVo.setChildMember(Boolean.valueOf(childMember));
		memberVo.setUserId(Integer.valueOf(userId));
		MemberVo respMemberVo = memberService.addNewMember(memberVo);

		writePojo2Json(resp, respMemberVo);
		
		memberService.fileImageDelet(profilePicture);


	}

	private String getPartValue(Part part) throws IOException {
		if (part != null) {
			InputStream inputStream = part.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			StringBuilder value = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				value.append(line);
			}
			return value.toString();
		}
		return null;
	}
}
