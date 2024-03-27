package sg.edu.nus.iss.ibfb4ssfassessment.controller;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Login;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;
import sg.edu.nus.iss.ibfb4ssfassessment.service.DatabaseService;

@Controller
@RequestMapping()
public class MovieController {
    @Autowired DatabaseService dbSvc;
    // TODO: Task 8
    @GetMapping(path = "/listing")
    public String displayMovies(HttpSession sess, Model model) {
      if (sess.getAttribute("isLoggedIn") != null) {
        List<Movie> movieList = dbSvc.getAllMovies(); 
        model.addAttribute("movies", movieList);
        return "listing";
      }
      return "redirect:/login";
    }

    // TODO: Task 9
    @PostMapping(path = "/book")
    public String bookMovie(HttpSession sess, @RequestParam(name = "movie") String movieId, Model model)  {
      Login login = (Login) sess.getAttribute("login");
      Date loginBirthDate = login.getBirthdate();
      Integer age = getAge(loginBirthDate);
      
      Movie movie = dbSvc.getMovieById(Integer.valueOf(movieId));

      
      if ((movie.getRated().equals("R")) && (age < 18)) {
        return "bookerror";
      }
      if ((movie.getRated().equals("PG-13")) && (age < 13)) {
        return "bookerror";
      }
      movie.setCount(movie.getCount()+1);
      model.addAttribute("movie", movie);
      return "booksuccess";
    }

    // TODO: Task 9
    // ... ...
    private Integer getAge(Date birthDate) {
      Date currentDate = new Date();
      long diff = TimeUnit.DAYS.convert(Math.abs(currentDate.getTime() - birthDate.getTime()), TimeUnit.MILLISECONDS);
      Integer years = (int) (diff / 365);
      return years;
    }  
}
