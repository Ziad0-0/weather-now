import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherAPI {

    public static void setConfiguration() throws IOException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your api key: ");
        String key = scan.nextLine();

        System.out.print("Please enter your longitude: ");
        String longitude = scan.nextLine();

        System.out.print("Please enter your latitude: ");
        String latitude = scan.nextLine();
        PrintWriter configWiter;

        configWiter = new PrintWriter(new File("files/config.txt"));

        configWiter.println(key);
        configWiter.println(longitude);
        configWiter.println(latitude);

        configWiter.close();

    }

    public static void saveWeatherJsonFile() throws IOException {

        // Get the key, longitude, latitude from the config file
        Scanner scan = new Scanner(new File("files/config.txt"));
        String key = scan.nextLine();
        String longitude = scan.nextLine();
        String latitude = scan.nextLine();
        scan.close();

        URL apiUrl = new URL("https://api.darksky.net/forecast/" + key + "/" + latitude + "," + longitude + "?units=si&exclude=minutely,hourly,daily,flags");

        URLConnection apiConnection = apiUrl.openConnection();

        InputStream inputStream = apiConnection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        FileWriter jsonWriter = null;

        jsonWriter = new FileWriter(new File("files/weather.json"));


        while ((line = br.readLine()) != null)
            jsonWriter.write(line);

        jsonWriter.close();

    }

    public static JSONObject getWeather() throws FileNotFoundException {

        return new JSONObject(new JSONTokener(new FileReader("files/weather.json"))).getJSONObject("currently");
    }
}
