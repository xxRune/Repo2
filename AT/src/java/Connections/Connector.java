
package Connections;



import Logger.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    
    
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    private String str="";
    
    public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlbaniaTravel","root","");
            System.out.println("the connection is OK");
                  
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Occured with DB Connection :" + ex);
        }
        return conn;
    }
                
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                 e.printStackTrace();
                System.out.println("Exception Occured in the process :" + e);
            }
        }
        
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (Exception e) {
                 e.printStackTrace();
                System.out.println("Exception Occured in the process :" + e);
            }
        }
        
        if(rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception Occured in the process :" + e);
            }
        }
                
    }
   
    
     public User findUser(String username,String password) throws ClassNotFoundException{
        
       
        str = "select username,password,role,name,surname from usr where username='"+username+"' and password='"+password+"'";
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlbaniaTravel","root","");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(str);
            while(rs.next()){
                String name=rs.getString("name");
                String surname=rs.getString("surname");
                int s_role=rs.getInt("role"); 
                return new User(name,surname,s_role);
            }  

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        finally{
            closeAll(conn, pstmt, rs);
            System.out.println("Finally block closed the connection OK from getAllMembers");
        }
        
   
        return null;

    }

}

    
