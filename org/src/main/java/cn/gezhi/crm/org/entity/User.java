package cn.gezhi.crm.org.entity;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    public User() {
    }

    public User(String username, String password, Integer employeeId) {
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
    }

    public User(Integer id, String username, String password, Integer employeeId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
    }
}