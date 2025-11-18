package ssystemdlc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_conn {
    public static Connection con(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:/ssystemdlc";
            String user = "";
            String pass="";
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        }catch (SQLException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
    return null;
    }       
}
