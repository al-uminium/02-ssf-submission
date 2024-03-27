package sg.edu.nus.iss.ibfb4ssfassessment.model;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

public class Login {
  @Email
  @NotEmpty
  @Max(50)
  private String email;

  @Past
  //! TODO add annotation for  format
  private Date birthdate;

    
}
