package Connection;

import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //Lazy singleton
    private static DBConnection dbConnection;

    private DBConnection() {
    }

    public static DBConnection getInstance(){
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {

        System.out.println("------------MySQL JDBC Connection------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        Connection connection = null;
        try {
            String user = "root";
            String password = "272253441";
            String url = "jdbc:mysql://localhost:3306/manage_book_market";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL Database connection to successfully");
        } catch (
                SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return connection;
    }
}
