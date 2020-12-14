/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sempledatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class InsartData {
    
    private Connection connect=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet result=null;
    Scanner sc = null;
    
    
    void insartData()
    {
       try {
           connect = ApiClient.getInstance();
           sc = new Scanner(System.in);
           
           String query = " insert into employee_managemen_info (name, age, gender, blood_group, phone_number,salary)"
        + " values ( ?, ?, ?, ?, ?, ?)";
           preparedStatement = connect.prepareStatement(query);
           System.out.println("Enter the name :");
           preparedStatement.setString(1, sc.nextLine());
           System.out.println("Enter the age :");
           preparedStatement.setInt(2, sc.nextInt());
           sc.nextLine();
           System.out.println("Enter the gender :");
           preparedStatement.setString(3, sc.nextLine());
           System.out.println("Enter the blood group :");
           preparedStatement.setString(4, sc.nextLine());
           System.out.println("Enter the phone number :");
           preparedStatement.setString(5, sc.nextLine());
           System.out.println("Enter the salary :");
           preparedStatement.setInt(6, sc.nextInt());
       
           
  
           preparedStatement.execute();
           System.out.println("Create data successful");
           System.out.println("\n");
           

           
       } catch (SQLException ex) {
           Logger.getLogger(InsartData.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("EROOE ");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(InsartData.class.getName()).log(Level.SEVERE, null, ex);
       }
       /**finally{
            ApiClient.close();
        }
        **/
    
  }


}



