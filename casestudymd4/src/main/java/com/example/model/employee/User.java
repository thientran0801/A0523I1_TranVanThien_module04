package com.example.model.employee;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    private String user_name;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RoleUser> roleUserList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    public User() {
    }

    public User(String user_name, String password, List<RoleUser> role_userList, Employee employee) {
        this.user_name = user_name;
        this.password = password;
        this.roleUserList = role_userList;
        this.employee = employee;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUser> role_userList) {
        this.roleUserList = role_userList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
