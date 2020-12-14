
package sempledatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteData {
    private Connection connect=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet result=null;
    Scanner sc = null;
    
    void deleteData()
    {
        try {
            connect = ApiClient.getInstance();
            sc = new Scanner(System.in);
            
            String query = "delete from employee_managemen_info where id = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            System.out.println("Choose id :");
            preparedStatement.setInt(1, sc.nextInt());

    
            preparedStatement.execute();
      
            System.out.println("Data delete successful");
            System.out.println("\n");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /**finally{
            ApiClient.close();
        }
        **/
    }
}
