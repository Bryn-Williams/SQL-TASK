/*
import java.sql.*;

public class Singleton {

    private static Connection connection = null;

    //En este caso el constructor privado impide que ninguna
    //clase pueda instanciar un objeto de la clase Singleton
    private Singleton() {

    }

    public static Connection getConnection() {

        try {

            if (connection == null) {

                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/battleship";
                String pwd = "root";
                String usr = "root";

                Class.forName(driver);

                //GET A CONNECTION TO A DATABASE
                connection = DriverManager.getConnection(url, usr, pwd);
            }
        }
        //Control de excepciones
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return connection;
    }
}*/
