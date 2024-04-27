package employee.management.system;

import java.sql.*;
import java.util.Scanner;

class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","");
            ResultSet rs;
            try (Statement stmt = con.createStatement()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter address");
                String a = sc.next();
                System.out.println("Enter salary ");
                int n = sc.nextInt();
                System.out.println("Enter first name");
                String b = sc.next();
                System.out.println("Enter last name");
                String c = sc.next();

                PreparedStatement st = con.prepareStatement("insert into employee(address,fname,name,salary) values(?,?,?,?)");
                st.setString(1, a);
                st.setString(2, b);
                st.setString(3, c);
                st.setInt(4, n);
                System.out.println("Data Inserted");

                rs = stmt.executeQuery("select * from employee");
            }
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
            con.close();
        }catch(Exception e){ System.out.println(e);}
}
}