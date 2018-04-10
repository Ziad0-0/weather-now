import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        File configFile = new File("files/config.txt");
        if (!configFile.exists()) {
            UserInterface.showGreetingscreen();
            WeatherAPI.setConfiguration();
        }


        WeatherAPI.saveWeatherJsonFile();


        UserInterface.printWeather(WeatherAPI.getWeather());


    }


}
