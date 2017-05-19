import java.sql.*;
import java.util.Scanner;
//KEY CLASSES IN THIS API ARE:
//java.sql.DriverManager
//java,sql.Connection......Statement.......ResultSet.....DataSource

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("To create a player, press 1");
            System.out.println("To show a table, press 2");
            System.out.println("To look for a player, press 3");
            System.out.println("To delete a player, press 4");

            option = sc.nextInt();

            switch (option) {

                case 1:

                    System.out.println("Enter: id number");
                    Integer idnumber = sc.nextInt();

                    System.out.println("Enter first name");
                    String firstname = sc.next();

                    System.out.println("Enter middle name");
                    String midname = sc.next();

                    System.out.println("Enter last name");
                    String lastname = sc.next();

                    System.out.println("Enter password");
                    String password =  sc.next();

                    System.out.println("Enter email");
                    String email =  sc.next();

                    createPlayer(idnumber, firstname, midname, lastname, password, email);

                    break;

                case 2:
                    testConnection();
                    break;

                case 3:

                    System.out.println("Enter ID of player you wish to view");
                    int theinput = sc.nextInt();
                    findPlayerById(theinput);
                    break;

                case 4:

                    System.out.println("Enter ID of player you wish to delete");
                    int otherinput = sc.nextInt();
                    deletePlayerById(otherinput);
                    break;

                case 5:
                    option = 5;
                    break;
            }
        } while (option != 5);
    }

    public static void testConnection() {
        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);

            //1. Get a connection to database
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship", "root", "1234");

            //2. CREATE A STATEMENT
            Statement mystatement = myconn.createStatement();

            //3. EXECUTE SQL QUERY
            ResultSet myResultset = mystatement.executeQuery("select * from players");

            //4. PROCESS THE RESULT SET
            //WHILE READS DATA FROM EACH ROW.........next() MOVES CURSOR TO NEXT ROW
            while (myResultset.next()) {
                System.out.println(myResultset.getString("nombre") + " " + myResultset.getString("apellido1"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void findPlayerById(int idParameter) {
        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);

            //1. Get a connection to database
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship", "root", "1234");

            //2. CREATE A STATEMENT
            Statement mystatement = myconn.createStatement();

            //3. EXECUTE SQL QUERY
             String sql = "SELECT * FROM players WHERE id =" + idParameter ;

             ResultSet rs = mystatement.executeQuery(sql);

             rs.next();

             System.out.println(rs.getString(1));
             System.out.println(rs.getString(2));
             System.out.println(rs.getString(3));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void deletePlayerById(int idparameter){


        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);

            //1. Get a connection to database
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship", "root", "1234");

            //2. CREATE A STATEMENT
            Statement mystatement = myconn.createStatement();

            //3. EXECUTE SQL QUERY
            String sql = "DELETE from players WHERE id=" + idparameter;

            mystatement.executeUpdate(sql);


        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    //TEST
    public static void createPlayer(int id, String nombre, String apellido1, String apellido2, String password, String email){

        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);

            //1. Get a connection to database
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship", "root", "1234");

            //2. CREATE A STATEMENT
            PreparedStatement mystatement = myconn.prepareStatement("insert into players"
                    + "(id, nombre, apellido1, apellido2, password, email)"
                    + "values (?,?,?,?,?,?);");

          /*  //3. EXECUTE SQL QUERY
            String sql = "insert into players"
                    + "(id, nombre, apellido1, apellido2, password, email)"
                    + "values (?,?,?,?,?,?);";*/

            mystatement.setInt(1,id);
            mystatement.setString(2,nombre);
            mystatement.setString(3,apellido1);
            mystatement.setString(4,apellido2);
            mystatement.setString(5, password);
            mystatement.setString(6, email);


            mystatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}


