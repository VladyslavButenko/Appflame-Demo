package com.example.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class PlaygroundApplication {

    public static int counter = 0;
    public static int numberOfRequests = 100;
    public static BufferedReader reader;
    public static PrintWriter printWriter;
    public static final String ENDPOINT = "http://localhost:8080/counter";


    public static void main(String[] args) throws IOException {
        SpringApplication.run(PlaygroundApplication.class, args);
        FileWriter fileWriter = new FileWriter("output.txt");
        printWriter = new PrintWriter(fileWriter);

        URL url = new URL(ENDPOINT);
        System.out.println("Calling the " + ENDPOINT + " endpoint for " + numberOfRequests + " times.");
        for (int a = 0; a < numberOfRequests; a++)
            callEndpoint(url);
        printWriter.close();
    }

    public static void callEndpoint(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
            printWriter.println(inputLine);
        }
        reader.close();
    }
}
