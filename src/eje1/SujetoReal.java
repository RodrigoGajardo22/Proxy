package eje1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SujetoReal implements Sujeto {

	private String ApiUrl = "https://api.openweathermap.org/data/2.5/weather?q=viedma,032&lang=sp&APPID=829a4f9285588fbe1fd89339a20fd69c&units=metric";
	private String unidad = "&units=mettic";                                                                                                           //

	// -------------------------------------------------------------------------
	public String pronostico() {
		HttpClient           httpClient = HttpClient.newHttpClient();
		HttpRequest          request    = HttpRequest.newBuilder().uri(URI.create(ApiUrl)).build();
		HttpResponse<String> response;
		String               clima      = "";
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			String jsonString = response.body();
			Gson   gson       = new GsonBuilder().create();
			var    jsonObject = gson.fromJson(jsonString, JsonObject.class);
			clima = jsonObject.getAsJsonArray("weather").asList().get(0).getAsJsonObject().get("description")
					.toString();
		} catch (IOException | InterruptedException e) {
			throw new OpenWeatherException(e, clima);

		}

		return clima;
	}

	// -------------------------------------------------------------------------

	public String temperatura() {
		String temperature = "";

		URL    url;
		try {
			url = new URL(ApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// Lee la respuesta
			BufferedReader reader   = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder  response = new StringBuilder();
			String         line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Procesa los datos JSON de la respuesta
//			String jsonResponse = response.toString();
//			temperature = jsonResponse.split("\"temp\":")[1].split(",")[0];

			JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
			double     grados     = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
			temperature += grados;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return temperature;
	}
}
