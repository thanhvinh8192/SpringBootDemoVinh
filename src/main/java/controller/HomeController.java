package controller;

import controller.request.LoginRequest;
import controller.request.RegisterRequest;
import model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.BookServices;
import services.UserServices;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    UserServices userServices;
    @Autowired
    BookServices bookServices;

    @PostMapping(value = "/login")
   public String login(@RequestBody LoginRequest request){
        String result = userServices.login(request);
        return result;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest request){
        String result = userServices.register(request);
        return result;
    }

    @GetMapping(value = "book/{cateID}")
    public List<BookModel> getAllBookByCateID(@PathVariable(value = "cateID") Integer cateID){
        List result = bookServices.findAllByCategoryID(cateID);
        return result;
    }

}