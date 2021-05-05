package services;

import model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServices {

    @Autowired
    Connection connection;

    public List<BookModel> findAllByCategoryID(Integer cateID){
        List<BookModel> response = new ArrayList<>();
        try{
            String sqlQuery = "SELECT * FROM `manage_book_market`.`BOOK` WHERE CATEGORY_idBOOK_CATEGORY = " + cateID;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                int idBook = resultSet.getInt("idBOOK");
                String title = resultSet.getString("Title");
                Time releaseTime = resultSet.getTime("ReleaseTime");
                String description = resultSet.getString("Decription");
                String author = resultSet.getString("Author");
                int price = resultSet.getInt("Price");
                String photoLink = resultSet.getString("PhotoLink");
                int idCate = resultSet.getInt("CATEGORY_idBOOK_CATEGORY");
                BookModel bookEntity = new BookModel(idBook, title, releaseTime, description, author, price, photoLink, idCate);
                response.add(bookEntity);
            }
            statement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return response;
    }
}
