package com.javaweb.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;

    @Column(name = "username",unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isActive")
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private RoleEntity roleID;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private EmployeeEntity employeeID;

    @ManyToOne
    @JoinColumn(name = "lessorID")
    private LessorEntity lessorID;

    @ManyToOne
    @JoinColumn(name = "lesseeID")
    private LesseeEntity lesseeID;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RoleEntity getRoleID() {
        return roleID;
    }

    public void setRoleID(RoleEntity roleID) {
        this.roleID = roleID;
    }

    public EmployeeEntity getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(EmployeeEntity employeeID) {
        this.employeeID = employeeID;
    }

    public LessorEntity getLessorID() {
        return lessorID;
    }

    public void setLessorID(LessorEntity lessorID) {
        this.lessorID = lessorID;
    }

    public LesseeEntity getLesseeID() {
        return lesseeID;
    }

    public void setLesseeID(LesseeEntity lesseeID) {
        this.lesseeID = lesseeID;
    }
}
