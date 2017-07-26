package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

	private final String USER_AGENT = "Mozilla/5.0";

	public String getResponse(String lat, String lng) throws Exception {
		Request req = new Request();
		System.out.println("Sending Request:");
		return req.sendGet(lat, lng);
	}

	public String sendGet(String lat, String lng) throws Exception {
		// TODO Auto-generated method stub
		String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&sensor=false";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result
		//System.out.println(response.toString());
		return response.toString();
	}
}
