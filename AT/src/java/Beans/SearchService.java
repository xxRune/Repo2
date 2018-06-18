
package Beans;

//import entities.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(name="searchService")
public class SearchService {
    
    private List<Manager> listSearch;
    
    @PostConstruct
    public void init(){
        try {
            Manager mg = new Manager();
            this.listSearch=mg.tags();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Manager> getSearchList(){
        return listSearch;
    }
}
