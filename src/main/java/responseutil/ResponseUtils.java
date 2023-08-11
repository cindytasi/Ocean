package responseutil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {

	public static void sendJsonResponse(HttpServletResponse response, String json) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
