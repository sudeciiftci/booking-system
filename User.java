public class User {

    private String userName;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role){
        this.userName = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setName(String name) { this.userName = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }

    void login(){

    }

    void register(){

    }

    void updateProfile(){
        
    }
}