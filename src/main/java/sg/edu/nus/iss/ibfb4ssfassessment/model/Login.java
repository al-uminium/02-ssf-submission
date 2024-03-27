package sg.edu.nus.iss.ibfb4ssfassessment.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Login {
  @Email
  @NotEmpty(message = "Cannot be empty")
  @Size(min = 1, max = 50, message = "Must be between 1 to 50")
  private String email;

  @Past
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date birthdate;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

    
}
