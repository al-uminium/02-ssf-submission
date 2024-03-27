package sg.edu.nus.iss.ibfb4ssfassessment.model;

import java.util.Date;

public class Movie {
  private Integer movieId;
  private String title; 
  private String year;
  private String rated;
  private Long releaseDate;
  private String runTime;
  private String genre;
  private String director;
  private Double rating; 
  private Date formattedReleaseDate;
  private Integer count=0;
  
  public Integer getMovieId() {
    return movieId;
  }
  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getYear() {
    return year;
  }
  public void setYear(String year) {
    this.year = year;
  }
  public String getRated() {
    return rated;
  }
  public void setRated(String rated) {
    this.rated = rated;
  }
  public Long getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(Long releaseDate) {
    this.releaseDate = releaseDate;
  }
  public String getRunTime() {
    return runTime;
  }
  public void setRunTime(String runTime) {
    this.runTime = runTime;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }
  public Double getRating() {
    return rating;
  }
  public void setRating(Double rating) {
    this.rating = rating;
  }
  public Date getFormattedReleaseDate() {
    return formattedReleaseDate;
  }
  public void setFormattedReleaseDate(Date formattedReleaseDate) {
    this.formattedReleaseDate = formattedReleaseDate;
  }
  public Integer getCount() {
    return count;
  }
  public void setCount() {
    this.count++;
  }

  @Override
  public String toString() {
    return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", releaseDate="
        + releaseDate + ", runTime=" + runTime + ", genre=" + genre + ", director=" + director + ", rating=" + rating
        + ", formattedReleaseDate=" + formattedReleaseDate + ", count=" + count + "]";
  }
}
