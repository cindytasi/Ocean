package common;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductService;
import shop.vo.Image;


@WebServlet("/ImageSevlet")
public class ImageSevlet extends HttpServlet {
	
	private ProductService productService;
	
    public void init() {
    	productService = new ProductService();
    }   
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageIdstr = request.getParameter("id");
		Image image = productService.getImageById(Integer.valueOf(imageIdstr));
		response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream in = new BufferedInputStream(image.getImg1());
        byte[] buf = new byte[4 * 1024]; // 4K buffer
        int len;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        in.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
