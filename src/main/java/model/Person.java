package main.java.model;

import java.util.Objects;
abstract class Person {

    private int id;
    private String username;
    private String gender;
    private String birthDate;
    private String email;
    private String address;
    private String phone;
    private String userPassword;

    // constructor without password
    public Person(int id, String username, String gender, String birthDate, String email, String address, String phone) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.userPassword = null;
    }

    // constructor with password
    public Person(int id, String username, String gender, String birthDate, String email, String address, String phone, String userPassword) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
