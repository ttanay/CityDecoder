package code;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseResponse {

	public String parseResponse(String JSONResponse) throws Exception {
		Object obj = new JSONParser().parse(JSONResponse);
		System.out.println("Started parsing JSON");
		JSONObject mainObject = (JSONObject)obj;
		JSONArray results = (JSONArray)mainObject.get("results");
		for(int i = 0; i < results.size(); i++) {
			JSONObject resultsObject = (JSONObject)results.get(i);
			JSONArray addressComponents = (JSONArray)resultsObject.get("address_components");
			for(int j = 0; j < addressComponents.size(); j++) {
				JSONObject addressCompObject = (JSONObject)addressComponents.get(j);
				JSONArray types = (JSONArray)addressCompObject.get("types");
				for(int k = 0; k < types.size(); k++) {
					String typesValue = types.get(k).toString();
					if(typesValue.equals("locality")) {
						String cityName = (String) addressCompObject.get("short_name");
						return cityName;
					}
				}
			}
		}	
		return null;
	}

}
