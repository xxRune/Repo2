
package Logger;

import Connections.Connector;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="control")
@SessionScoped
public class Controller {
    
    private static final long s = 10000000000L;
    
    private String username;
    private String password;
    private String role;
    private Connector dataManager;
    private User sessionUser;
    
      @PostConstruct
    public void init(){
        if(dataManager==null){
            dataManager=new Connector();
        }
    }
    
    public String login() throws ClassNotFoundException{
        sessionUser=dataManager.findUser(username, password);
        
        if(sessionUser!=null){
            setRole();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", role);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
             
                 
            return "admin/admin.xhtml?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is invalid"));
        }
        
        return "login.xhtml";
    }
    
    
     public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        sessionUser=null;
        return "login.xhtml?faces-redirect=true";
    }
    
      public String redirect(int role){
          
          //Currently not implemented. Copy-Pasted from classroom code
          
        FacesContext context2 = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
       //check it out in Output console 
        System.out.println("Here is just a test how we may get both user nad role ");
        System.out.println("Username: "+ session.getAttribute("username") +" and role is: "+session.getAttribute("role"));
        //use this for adding business logic to your web app...
        
        
        if(role == 1)
            return "/admin/admin.xhtml?faces-redirect=true";
        //else if(role ==2)
          //  return "/inner/admin/index.xhtml?faces-redirect=true";
        else
            return "index.xhtml?faces-redirect=true";
               
    }
    
    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    public String getRole() {
        return "1";
    }

    public void setRole() {
        this.role = Integer.toString(sessionUser.getRole()) ;
        //here you must do a query to the DB like:
        // "Select role from users where username = "+getUsername()+ "and password" +getPassword()" 
        //than the value you get after statment and excecute query etc..
        //you complete the above code this.role  = role (the value you get from the DB) 
    }
}
