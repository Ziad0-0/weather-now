import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {


    public static void showGreetingscreen() throws FileNotFoundException {

        File greetingFile = new File("files/greeting.ascii");
        Scanner scan = new Scanner(greetingFile);
        String line;
        while (scan.hasNext()) {
            System.out.print("			");
            line = scan.nextLine();
            System.out.println(line);
        }

        System.out.println();
        scan.close();
    }

    /*
        Copied from https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        Credits go to https://stackoverflow.com/users/4422856/shakram02
     */
    private class ConsoleColor {

        // Reset terminal text color to default
        public static final String RESET = "\033[0m";

        public static final String BLACK = "\033[0;30m";
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String YELLOW = "\033[0;33m";
        public static final String BLUE = "\033[0;34m";
        public static final String PURPLE = "\033[0;35m";
        public static final String CYAN = "\033[0;36m";
        public static final String WHITE = "\033[0;37m";

        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";
    }

    /*
        Credits go to http://www.fileformat.info/info/unicode/char/search.htm for their very helpful icon search service
     */
    private class ConsoleIcon {

        public static final String SUN = "\u263C";
        public static final String MOON = "\uD83C\uDF15";
        public static final String STAR = "\u2606";
        public static final String RAINYCLOUD = "\uD83C\uDF27";
        public static final String CLOUD = "\u2601";
        public static final String SNOW = "\u2744";
        public static final String THUNDER = "\u26C8";
        public static final String SNOWYCLOUD = "\uD83C\uDF28";
        public static final String FOG = "\uD83C\uDF2B";
        public static final String TORNADO = "\uD83C\uDF2A";
        public static final String CYCLONE = "\uD83C\uDF00";
        public static final String CELSIUS = "\u2103";


    }

    public static void printWeather(JSONObject weatherjson) {

        System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT + "Status: ");

        String icon = weatherjson.getString("icon");

        if (icon.equals("clear-day"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.SUN);
        else if (icon.equals("clear-night")) {
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.STAR + ConsoleIcon.MOON + ConsoleIcon.STAR);
        }else if (icon.equals("rain"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.RAINYCLOUD);
        else if (icon.equals("snow"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.SNOW);
        else if (icon.equals("sleet") || icon.equals("hail"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.SNOWYCLOUD);
        else if (icon.equals("wind"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.CYCLONE);
        else if (icon.equals("fog"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.FOG);
        else if (icon.equals("cloudy"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.CLOUD);
        else if (icon.equals("partly-cloudy-day"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.SUN + ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.CLOUD);
        else if (icon.equals("partly-cloudy-night"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.MOON + ConsoleIcon.CLOUD);
        else if (icon.equals("thunderstorm"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.THUNDER);
        else if (icon.equals("tornado"))
            System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT + ConsoleIcon.TORNADO);


        System.out.println(ConsoleColor.GREEN + ' ' + weatherjson.getString("summary"));


        System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT + "Temperature: ");

        double temperature = weatherjson.getDouble("temperature");

        System.out.println(ConsoleColor.GREEN+ temperature + ConsoleIcon.CELSIUS);


        System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT + "Apparent temperature: ");

        double apparentTemperature = weatherjson.getDouble("apparentTemperature");

        System.out.println(ConsoleColor.GREEN + apparentTemperature + ConsoleIcon.CELSIUS);


        System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT + "Humidity: ");

        double humidity = weatherjson.getDouble("humidity");

        System.out.println(ConsoleColor.GREEN + humidity + " from 1");


        System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT + "Wind speed: ");

        double windSpeed = weatherjson.getDouble("windSpeed");

        System.out.println(ConsoleColor.GREEN + windSpeed + " m/s");


        System.out.print(ConsoleColor.RESET);

    }
}
