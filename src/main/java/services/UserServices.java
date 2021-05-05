package services;

import controller.request.LoginRequest;
import controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServices {

    @Autowired
    Connection connection;
    public String login(LoginRequest request){

        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + request.getPhoneNumber() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()) {
                if(request.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    if(request.getPassword().equals(rs.getString("Password"))){
                        return  "Login Success";
                    }
                    else return "Email or Password is incorrect";
                }
                else return "Account is not exist!";

            }
            stm.close();
            connection.close();
        }
        catch (SQLException sqlException)
        {
            System.out.println(sqlException);
        }
        return "Success";
    }

    public String register(RegisterRequest request){
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + request.getPhoneNumber() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            if (!request.checkPhoneNumber(request.getPhoneNumber()))
                return "Phone Number Incorrect";
            while (rs.next()){
                if(request.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    return "Phone Number is exists";
                }
                else{
                    if(!request.checkEmail(request.getEmail())){
                        return "Email is must be Gmail";
                    }
                    if (!request.checkPassword(request.getPassword())){
                        return "Password invalid";
                    }
                }
            }
            String sqlInsertUser = "INSERT INTO `manage_book_market`.`USER` (`PhoneNumber`, `Username`, `Password`, `Email`) VALUES ('" + request.getPhoneNumber() + "', '" + request.getUserName() + "', '" + request.getPassword() + "', '" + request.getEmail() + ");\n";
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
