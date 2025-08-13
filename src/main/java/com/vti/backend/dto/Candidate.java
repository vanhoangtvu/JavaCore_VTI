package com.vti.backend.dto;

/*
 * Entity cha: chua thuoc tinh chung + password de login
 * Ten bien + comment khong dau
 */
public abstract class Candidate {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
