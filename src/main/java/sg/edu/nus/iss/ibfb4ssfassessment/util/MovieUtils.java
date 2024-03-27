package sg.edu.nus.iss.ibfb4ssfassessment.util;

import java.util.Date;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;

public class MovieUtils {

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
  
  public Movie convertJsonToMovie(JsonObject val) {
    Movie movie = new Movie();
    movie.setMovieId(val.getInt("Id"));
    movie.setTitle(val.getString("Title"));
    movie.setYear(val.getString("Year"));
    movie.setRated(val.getString("Rated"));
    movie.setReleaseDate(Long.valueOf(val.get("Released").toString()));
    movie.setRunTime(val.getString("Runtime"));
    movie.setGenre(val.getString("Genre"));
    movie.setDirector(val.getString("Director"));
    movie.setRating(Double.valueOf(val.get("Rating").toString()));
    movie.setCount(val.getInt("Count"));
    movie.setFormattedReleaseDate(convertEmsToDate(Long.valueOf(val.get("Released").toString())));
    return movie;
  }

  public Date convertEmsToDate(Long ems) {
    Date frDate = new Date(ems);
    return frDate;
  }
}
