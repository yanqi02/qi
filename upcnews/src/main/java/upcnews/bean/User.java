package upcnews.bean;


public class User {
    private String userName;
    private String password;
    private String id;
    private int authority= upcnews.bean.Authority.normal;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", authority=" + authority +
                '}';
    }

    public User(String userName, String password, String id, int authority) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.authority = authority;
    }

    public int getAuthority() {

        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
public  User()
{}
    public User(String t111111, String s) {

    }
}
