import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main (String args[]){

        String connUrl = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
        String user = "root";
        String pw = "password";

        try {
            System.out.println("Test connection");
            Connection connection = DriverManager.getConnection(connUrl, user, pw);
            System.out.println("Connection cuccess");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}