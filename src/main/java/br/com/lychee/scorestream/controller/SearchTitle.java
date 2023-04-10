package br.com.lychee.scorestream.controller;

import br.com.lychee.scorestream.model.Movie;
import br.com.lychee.scorestream.model.Title;
import br.com.lychee.scorestream.model.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchTitle {
    //This code need to refactor!!!
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        var movieName = "";
        List<Title> titlesList = new ArrayList<>();

         Gson gson = new GsonBuilder()
                 .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                 .setPrettyPrinting()
                 .create();

        while (!movieName.equalsIgnoreCase("quit")) {
            System.out.println("Enter a movie name :");
            movieName = reader.nextLine().trim().replaceAll("\\s", "+");

            if (movieName.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Validated : " + movieName);

            var url = "http://www.omdbapi.com/?t=%s&apikey=778fb36d".formatted(movieName);

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                var json = response.body();
                System.out.println(json);

                //Record class is being used so that annotation is not necessary (@SerializerName)
                //The builder tool is being used to communicate the Java writing pattern (camelCase)
                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);

                Title myTitle = new Movie(myTitleOmdb);
                System.out.println(myTitle);

                titlesList.add(myTitle);

            } catch (Exception e) {
                System.out.println("The error message : " + e);
            }

        }

        FileWriter writeJson = new FileWriter("movies.json");
        writeJson.write(gson.toJson(titlesList));
        writeJson.close();

        System.out.println(titlesList);
        System.out.println("Finally program");
    }
}
