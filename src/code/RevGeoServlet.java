package code;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RevGeoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("Hello, world");
		String lat = "48.8584", lng = "2.2945";
		try {
			String cityName = new ParseResponse().parseResponse(new Request().getResponse(lat, lng));
			//Do whatever with this cityName
			resp.getWriter().println("city of (" + lat + "," + lng + ") is: " + cityName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
