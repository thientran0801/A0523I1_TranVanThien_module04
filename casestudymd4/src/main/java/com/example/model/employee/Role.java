package com.example.model.employee;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<RoleUser> roleUserList;

    public Role() {
    }

    public Role(Long id, String role_name, List<RoleUser> role_userList) {
        this.id = id;
        this.role_name = role_name;
        this.roleUserList = role_userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUser> role_userList) {
        this.roleUserList = role_userList;
    }
}
