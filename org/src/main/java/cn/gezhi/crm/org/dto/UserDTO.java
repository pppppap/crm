package cn.gezhi.crm.org.dto;

import cn.gezhi.crm.org.entity.Employee;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/20
 */
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employee=" + employee.getName() +
                '}';
    }
}