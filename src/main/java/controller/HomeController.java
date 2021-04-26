package controller;

import Connection.DBConnection;
import model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @PostMapping(value = "/login")
   public String login(@RequestBody User user){
        String response = null;
        DBConnection dbConnection =  DBConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + user.getPhoneNumber() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()) {
                if(user.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    if(user.getPassword().equals(rs.getString("Password"))){
                        return  response = "Login Success";
                    }
                    else return response =  "Email or Password is incorrect";
                }
                else return response =  "Account is not exist!";

            }
            stm.close();
            connection.close();
        }
        catch (SQLException sqlException)
        {
            System.out.println(sqlException);
        }
        return response;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user){
        DBConnection dbConnection =  DBConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + user.getPhoneNumber() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            if (!user.checkPhoneNumber(user.getPhoneNumber()))
                return "Phone Number Incorrect";
            while (rs.next()){
                if(user.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    return "Phone Number is exists";
                }
                else{
                    if(!user.checkEmail(user.getEmail())){
                        return "Email is must be Gmail";
                    }
                    if (!user.checkPassword(user.getPassword())){
                        return "Password invalid";
                    }
                }
            }
            String sqlInsertUser = "INSERT INTO `manage_book_market`.`USER` (`PhoneNumber`, `Username`, `Password`, `Email`) VALUES ('" + user.getPhoneNumber() + "', '" + user.getUserName() + "', '" + user.getPassword() + "', '" + user.getEmail() + ");\n";
            stm.executeUpdate(sqlInsertUser);
            stm.close();
            connection.close();
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return "Register Success";
    }
}