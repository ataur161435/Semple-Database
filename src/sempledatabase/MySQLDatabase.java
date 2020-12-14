package sempledatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDatabase {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Scanner sc = null;

    void readData() {
        try {
            connect = ApiClient.getInstance();
            sc = new Scanner(System.in);
            //statement = connect.createStatement();
            //result = statement.executeQuery("SELECT * FROM blood_donor_information.donor_list");

            String query = "SELECT name,age,gender,blood_group,phone_number,salary FROM employee_managemen_info WHERE salary=?";
            preparedStatement = connect.prepareStatement(query);

            System.out.println("Enter value : ");
            preparedStatement.setInt(1, sc.nextInt());
            result = preparedStatement.executeQuery();
            if (result.first()) {
                while (result.next()) {
                    System.out.println("Name: " + result.getString("name"));
                    System.out.println("Age: " + result.getString("age"));
                    System.out.println("Gender: " + result.getString("gender"));
                    System.out.println("Blood_group: " + result.getString("blood_group"));
                    System.out.println("Phone_number : " + result.getString("phone_number"));
                    System.out.println("Salaey : " + result.getString("salary"));
                    System.out.println("\n");
                }
            } else {
                System.out.println("Not result found");
            }
            System.out.println("\n");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Myerror: ");
        }
        
        /**finally{
            ApiClient.close();
        }
        **/

    }

}
