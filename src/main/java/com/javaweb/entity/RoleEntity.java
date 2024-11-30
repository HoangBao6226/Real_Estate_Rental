package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "roleName", nullable = false)
    private String roleName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "roleID")
    private List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AccountEntity> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<AccountEntity> listAccount) {
        this.listAccount = listAccount;
    }
}
