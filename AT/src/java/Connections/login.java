
package Connections;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean (name="log")
@SessionScoped
public class login implements Serializable{

    private static final long s =10000000000000000L;

    private String email;
    private String password;
    private static String user_type;
    private ResultSet result;
    private static int userID;
    private static String session_name = null;

    public String validate() {
        
        Connector db = new Connector();
        String email_query = null , pass_query = null;
        
        try {
            Statement stm = db.getConnection().createStatement();
            String query = "SELECT * FROM usr WHERE email = '"+this.email+"'";
            this.result = stm.executeQuery(query);
            this.result.next();
            email_query = this.result.getString("username");
            pass_query = this.result.getString("pass");
            this.userID = this.result.getInt("id");
            } catch (Exception e) {
                System.err.println("Error is : "+e);
            }
        
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.email.equals(email_query) && this.password.equals(pass_query)){
            
            context.getExternalContext().getSessionMap().put("user", "admin");
            
            /*
            if(this.user_type.equals("users")){
                System.out.println("here");
                context.getExternalContext().getSessionMap().put("user", "user");
            }
            else if(this.user_type.equals("admins")){
                context.getExternalContext().getSessionMap().put("user", "admin");
            } */
            
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            this.session_name = (String) session.getAttribute("user");
            session.setMaxInactiveInterval(60 * 10);
        }
        else{
            this.email = null;
            this.password = null;
        }
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout() {
        String redirect = "/index.xhtml?faces-redirect=true";
        if(this.session_name.equals("admin")){
            redirect = "/admin.xhtml?faces-redirect=true";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        this.session_name = (String) session.getAttribute("user");
        return redirect;
    }
    
    public void setInfo(String user_type){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getCurrentInstance().getExternalContext().getRequest();
        this.email = request.getParameter("usermail");
        this.password = request.getParameter("passw");
        this.user_type = user_type;
        if(this.session_name != null){
            logout();
        }
        validate();
}
    
    public String getSessionName(){
        return this.session_name;
    }
    
    public int getUserID(){
        return this.userID;
    }

    
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getUser_type() {
        return user_type;
    }

    public static void setUser_type(String user_type) {
        login.user_type = user_type;
    }
}
