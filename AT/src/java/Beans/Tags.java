
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="tgbean")
public class Tags implements Serializable{
    
    private static final long s = 100000000000000000L;
    
    private String tag;
     

   
    
    private static String currentselected;
    private static Set<String> stg = new HashSet<>();
    private static List<String> cat = new ArrayList<>();
    
    public Tags(){
        
    }
    
    public Tags(String tag){
        this.tag=tag;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the stg
     */
    public  Set<String> getStg() {
        return stg;
    }

    public  List<String> getCat() {
        return cat;
    }

    public  void setCat(List<String> cat) {
        Tags.cat = cat;
    }

   
    
     public String getCurrentselected() {
        return currentselected;
    }

    public void setCurrentselected(String currentselected) {
        this.currentselected = currentselected;
    }

    
    public Set<String> display(){
        return stg;
    }
    
    public void addtoList(){
        
        System.out.println("Something"+stg);
        
        this.stg.add(currentselected);
        
       
    }
      
    public String delAll(){
        stg.clear();
        return "/tags.xhtml";
    }
    
    
 
    
}
