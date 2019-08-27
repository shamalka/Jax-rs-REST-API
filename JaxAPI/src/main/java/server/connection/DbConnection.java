package server.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection connection;

    public DbConnection(){
        Connect();
    }

    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Mysql Driver Not Found.!");
            return;
        }
        System.out.println("Driver initialized.!");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "");
            System.out.println("Mysql Connection Established.!");
        }catch(SQLException e){
            System.out.println("Mysql Connection Failed.!");
            return;
        }


    }
}
