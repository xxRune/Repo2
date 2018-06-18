
package Beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean(name="searchController")
public class SearchController {
    
     private String searchName;

    /**
     * @return the searchName
     */
    public String getSearchName() {
        return searchName;
    }

    /**
     * @param searchName the searchName to set
     */
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    
    @ManagedProperty("#{searchService}")
    private SearchService searchService;

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
    
   private SearchService getSearchService(){
       return searchService;
   }
   
   public List<String> completeText(String searchName) throws ClassNotFoundException{
       Manager mg = new Manager();
       return mg.search(searchName);
   }
    
    
}
