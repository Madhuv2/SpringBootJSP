package com.yash.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Detail")
public class UserDetail {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
//private int user_id;

@NotNull
@Size(max = 65)
@Column(name = "first_name")
private String first_name;
@Size(max = 65)
@Column(name = "last_name")
private String last_name;
@NotNull
@Size(max = 65)
@Column(name = "phone_number")
private String phone_number;
@NotNull
@Size(max = 65)
@Column(name = "address")
private String address;

@OneToOne(fetch=FetchType.LAZY,optional = false)
@JoinColumn(name = "user_id", nullable = false)

private User user;




public UserDetail(){

}

    public UserDetail(int id, int user_id, String first_name, String last_name, String phone_number, String address) {
        this.id = id;
        //this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
