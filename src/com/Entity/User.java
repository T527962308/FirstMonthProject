package com.Entity;

public class User {
    private int id;
    private String userName;
    private String password;
    private int sex;
    private String hobbys;
    private String email;
    private String addrs;
    private String flag;
    public User(int id, String userName, String password, int sex, String hobbys, String email, String addrs, String flag){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.hobbys = hobbys;
        this.email = email;
        this.addrs = addrs;
        this.flag = flag;
    }
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHobbys() {
        return hobbys;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
