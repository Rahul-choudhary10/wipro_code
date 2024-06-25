package day25;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SimpleHttpClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String urlString="http://www.example.com";
		try {
			URL url=new URL(urlString);
			
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			
			int responseCode=connection.getResponseCode();
			System.out.println("Response code: "+ responseCode);
			Map<String,List<String>> headers=connection.getHeaderFields();
			System.out.println("Response Headers: ");
			for(Map.Entry<String, List<String>> entry : headers.entrySet()) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response=new StringBuilder();
			while((inputLine=in.readLine())!=null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("Response Body : ");
			System.out.println(response.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
