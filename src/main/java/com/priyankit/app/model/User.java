
package com.priyankit.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private int role;
  
  public User(){}
  
  public User(String username, String password, int role){
    
    this.setUsername(username);
    this.setPassword(password);
    this.setRole(role);
    
  }
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
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
  public int getRole() {
    return role;
  }
  public void setRole(int role) {
    this.role = role;
  }
  
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + "'" +
                ", username='" + username + "'" +
                ", password='" + password + "'" +
                ", role='" + role + "'" +
                '}';
    }
  
}