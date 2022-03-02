package com.chinafestival.pojo;

public class User {
    private int u_id;
    private String u_name;
    private String getpraise;
    private String signature;
    private String headphoto;
    private String statecode;
    private String password;

    @Override
    public String toString() {
        return super.toString();
    }

    public User() {
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getGetpraise() {
        return getpraise;
    }

    public void setGetpraise(String getpraise) {
        this.getpraise = getpraise;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
