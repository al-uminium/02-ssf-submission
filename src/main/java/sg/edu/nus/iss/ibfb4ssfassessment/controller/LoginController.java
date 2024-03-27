package sg.edu.nus.iss.ibfb4ssfassessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    // TODO: Task 6
    @GetMapping(path = {"/", "/index.html"})
    public String login(Model model) {
      model.addAttribute("login", new Login());
      return "login";
    }

    
    // TODO: Task 7
    @PostMapping(path = "/")
    public String processlogin(@Valid Login login, BindingResult bindingResult, HttpSession sess) {
      if (bindingResult.hasErrors()) {
        return "login";
      } 

      sess.setAttribute("login", login);
      sess.setAttribute("isLoggedIn", true);
      System.out.println(sess.getAttribute("login").toString());
      return "success";
    
    }
    

    // For the logout button shown on View 2
    // On logout, session should be cleared
    @PostMapping(path = "/logout")
    public String logout(HttpSession sess) {
      sess.invalidate();
      return "logout";
    }
    
}
