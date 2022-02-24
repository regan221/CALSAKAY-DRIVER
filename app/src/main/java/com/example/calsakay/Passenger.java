package com.example.calsakay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Passenger {
    private int id;
    private String first_name;
    private String last_name;
    private Date birthday;
    private String gender;
    private String mobile_number;
    private String address;
    private String medical_job;
    private String company_name;
    private String company_address;
    private String company_number;
    private String front_image_name;
    private String back_image_name;
    private String orcr_front_img;
    private String orcr_back_img;
    private String email;
    private String user_image;
    private String username;
    private String password;
    private int account_status;
    private Date date_joined;


    public Passenger(String id, String first_name, String last_name, String birthday, String gender, String mobile_number, String address, String medical_job, String company_name, String company_address, String company_number, String front_image_name, String back_image_name, String orcr_front_img, String orcr_back_img, String email, String user_image, String username, String password, String account_status, String date_joined) throws Exception {
        SimpleDateFormat sdt = new SimpleDateFormat("MM-dd-yyyy");
        this.id = Integer.parseInt(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = sdt.parse(birthday);
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.address = address;
        this.medical_job = medical_job;
        this.company_name = company_name;
        this.company_address = company_address;
        this.company_number = company_number;
        this.front_image_name = front_image_name;
        this.back_image_name = back_image_name;
        this.orcr_front_img = orcr_front_img;
        this.orcr_back_img = orcr_back_img;
        this.email = email;
        this.user_image = user_image;
        this.username = username;
        this.password = password;
        this.account_status = Integer.parseInt(account_status);
        this.date_joined = sdt.parse(date_joined);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedical_job() {
        return medical_job;
    }

    public void setMedical_job(String medical_job) {
        this.medical_job = medical_job;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
    }

    public String getFront_image_name() {
        return front_image_name;
    }

    public void setFront_image_name(String front_image_name) {
        this.front_image_name = front_image_name;
    }

    public String getBack_image_name() {
        return back_image_name;
    }

    public void setBack_image_name(String back_image_name) {
        this.back_image_name = back_image_name;
    }

    public String getOrcr_front_img() {
        return orcr_front_img;
    }

    public void setOrcr_front_img(String orcr_front_img) {
        this.orcr_front_img = orcr_front_img;
    }

    public String getOrcr_back_img() {
        return orcr_back_img;
    }

    public void setOrcr_back_img(String orcr_back_img) {
        this.orcr_back_img = orcr_back_img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
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

    public int getAccount_status() {
        return account_status;
    }

    public void setAccount_status(int account_status) {
        this.account_status = account_status;
    }

    public Date getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }

}
