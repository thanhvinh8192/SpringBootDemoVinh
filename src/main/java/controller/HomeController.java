package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @PostMapping(value = "/login")
   public String login(@RequestBody LoginRequest request){
        String hardUser = "vinhnt";
        String hardPass = "123456";
        if(request.getUserName().equals(hardUser)&&request.getPassword().equals(hardPass)){
            return "Login Success";
        }
        else return "Invalid username or password";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user){
        return "Register Success";
    }
}