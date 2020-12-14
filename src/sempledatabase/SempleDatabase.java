
package sempledatabase;

import java.util.Scanner;

public class SempleDatabase {

   
    public static void main(String[] args) {
        
       //MySQLDatabase db = new MySQLDatabase();
       //db.readData();
       //InsartData isd = new InsartData();
       //isd.insartData();
       
       //DeleteData dd = new DeleteData();
       //dd.deleteData();
       
      // UpdateData ud = new UpdateData();
      // ud.updateData();
        while(true){
        System.out.println("C=Create data");
        System.out.println("R=Read data");
        System.out.println("U=Update data");
        System.out.println("D=Delete data");
        
        Scanner sc = null;
        sc = new Scanner(System.in);
        System.out.println("Enter any charecter :");
        String chr=sc.nextLine();
       switch(chr)
       {
           case "C":
               System.out.println("Create data");
               InsartData isd = new InsartData();
               isd.insartData();
               break;
           case "R":
               System.out.println("Read data");
               MySQLDatabase db = new MySQLDatabase();
               db.readData();
               break;
           case "U":
               System.out.println("Update data");
               UpdateData ud = new UpdateData();
               ud.updateData();
               break;
           case "D":
               System.out.println("Delete data");
               DeleteData dd = new DeleteData();
               dd.deleteData();
               break;
           case "CL":
               ApiClient.close();
               System.out.println("Database close successful");
               break;
           default:
               System.out.println("Not matching charecter");
               System.out.println("\n");
       }
       
          System.out.println("CL = Database close");
         
    }
    
}
}
