package sg.edu.nus.iss.ibfb4ssfassessment.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;
import sg.edu.nus.iss.ibfb4ssfassessment.repository.RedisRepo;
import sg.edu.nus.iss.ibfb4ssfassessment.util.MovieUtils;

@Service
public class DatabaseService {

    // {
    //   "Id": 12333,
    //   "Title": "Avatar",
    //   "Year": "2009",
    //   "Rated": "PG-13",
    //   "Released": 1261094400000,
    //   "Runtime": "162 min",
    //   "Genre": "Action, Adventure, Fantasy",
    //   "Director": "James Cameron",
    //   "Rating": 7.9,
    //   "Count": 0
    // }
    
    @Autowired RedisRepo repo;

    // TODO: Task 2 (Save to Redis Map)
    public void saveRecord(Movie movie) {
      JsonObject movieJson = Json.createObjectBuilder()
                                      .add("Id", movie.getMovieId())
                                      .add("Title", movie.getTitle())
                                      .add("Year", movie.getYear())
                                      .add("Rated", movie.getRated())
                                      .add("Released", movie.getReleaseDate())
                                      .add("Runtime", movie.getRunTime())
                                      .add("Genre", movie.getGenre())
                                      .add("Director", movie.getDirector())
                                      .add("Rating", movie.getRating())
                                      .add("Count", movie.getCount())
                                      .build();
      repo.mapAdd(movieJson);
      // System.out.println(movieJson.toString());
    }

    // TODO: Task 3 (Map or List - comment where necesary)
    public long getNumberOfMovies() {
      return repo.mapSize();
    }

    public Set<Object> getMovieKeys() {
      return repo.getAllMapKeys();
    }


//     public Movie getMovie(Integer index) {
//         return repo.getMovie(index);
//     }

    // TODO: Task 4 (Map)
    public Movie getMovieById(Integer movieId) {
      String movieJsonStr = repo.mapGet(movieId);
      JsonObject movieJson = convertStrToJsonObj(movieJsonStr);
      return new MovieUtils().convertJsonToMovie(movieJson);
    }

    // TODO: Task 5
    public List<Movie> getAllMovies() {
      List<Object> movieObjList = repo.getAllMapValues();
      List<Movie> listOfMovies = new ArrayList<>();
      
      for (Object obj : movieObjList) {
		    JsonObject movieJson = convertStrToJsonObj(obj.toString());
        Movie movie =  new MovieUtils().convertJsonToMovie(movieJson);
        listOfMovies.add(movie);
      }
      return listOfMovies;
    }

    public JsonObject convertStrToJsonObj(String str) {
      JsonReader jsonReader = Json.createReader(new StringReader(str));
      JsonObject jsonObj = jsonReader.readObject();
      return jsonObj;
    }
}
