
package Beans;

import static Beans.Manager.conn;
import static Beans.Manager.pstmt;
import static Beans.Manager.rs;
import Connections.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="travel")
@SessionScoped
public class Traveller {
    
    Connector cn = new Connector();
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    private String str="";
    
   
    private List<String> t = new ArrayList<String>();
    private List<String> c = new ArrayList<String>();
   
    private String actual;
    private String posURL;
    
    public Traveller(){
        
    }
    
    
    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }
    
     public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
    
    public String getPosURL() {
        return posURL;
    }

    public void setPosURL(String posURL) {
        this.posURL = posURL;
    }
    
    
    
    public Set<Traveller> process() throws ClassNotFoundException{
        
          Set<Traveller> res = new HashSet<>();
          res.clear();
          t.clear();
          c.clear();
          
        Manager mg = new Manager();
        Tags tg = new Tags();
        t.addAll(tg.getStg());
        c.addAll(tg.getCat());
        
        System.out.println("t from process "+t.toString());
        System.out.println("c from process "+c.toString());
        
      
               
        String category=c.get(0);
        
               for(String element: t){
                   
                 str="SELECT p.name, p.posURL FROM places as p \n" +
"LEFT JOIN categ as c on p.name = c.name\n" +
"LEFT JOIN tgs as t on p.id = t.id_fk\n" +
"WHERE p.category ='"+category+"'\n" +
"AND t.name = '"+element+"'";
                
                try {
             Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlbaniaTravel","root","");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(str);
            
            while(rs.next()){
                Traveller tr = new Traveller();
                tr.setActual(rs.getString("name"));
                //System.out.println("Inside rs.next "+i+" "+rs.getString("name"));
                res.add(tr);
                tr.setPosURL(rs.getString("posURL"));
                
            }  
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        finally{
            cn.closeAll(conn, pstmt, rs);
            System.out.println("Finally block closed the connection OK from getAllMembers");
        }
                
        }  
        
    return res;
    }
    
}
