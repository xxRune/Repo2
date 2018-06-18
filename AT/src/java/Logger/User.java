
package Logger;


public class User {
    
    private String name;
    private String surname;
    private int role;

    public User() {
    }

    public User(String name, String surname, int role) {
        this.name = name;
        this.surname = surname;
        this.role=role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + '}';
    }
    
    
}
