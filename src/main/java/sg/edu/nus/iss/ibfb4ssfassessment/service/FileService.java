package sg.edu.nus.iss.ibfb4ssfassessment.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;
import sg.edu.nus.iss.ibfb4ssfassessment.util.MovieUtils;

@Service
public record FileService() {


    // TODO: Task 1
    public List<Movie> readFile(String fileName) {
        List<Movie> listOfMovies = new ArrayList<>();
        BufferedReader reader;
        String json = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                json += line; 
                line = reader.readLine();
            }
            JsonReader jsonReader = Json.createReader(new StringReader(json));
		    JsonArray jsonString = jsonReader.readArray();
            for (JsonValue value : jsonString) {
                JsonObject obj = value.asJsonObject();
                Movie movie = new MovieUtils().convertJsonToMovie(obj);
                listOfMovies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfMovies;
    }

}
