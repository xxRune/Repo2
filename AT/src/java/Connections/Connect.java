
package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Connect {
    
 
    
    
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
    
}
