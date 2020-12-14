
package sempledatabase;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class ApiClient {
    
    private static Connection connector;
    
     static Connection getInstance() throws SQLException, ClassNotFoundException
    {
        if(connector==null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connector = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/employee_management?"+"user=root");
        }
        return connector;
    }
     static void close()
     {
        try {
            connector.close();
            System.out.println("Database close successful");
            System.out.println("\n");
        } catch (SQLException ex) {
            Logger.getLogger(ApiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  
}
