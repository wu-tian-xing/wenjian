package com.chinafestival.pojo;


public class Dynamic {

  private int d_id;
  private String details;
  private String picture;
  private String datetime;
  private int user_id;
  private  int num_review;


  public Dynamic() {
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public int getNum_review() {
    return num_review;
  }

  public void setNum_review(int num_review) {
    this.num_review = num_review;
  }

  public int getD_id() {
    return d_id;
  }

  public void setD_id(int d_id) {
    this.d_id = d_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }


  public String getPicture() {
    return picture;
  }

  public Dynamic(int d_id, String details, String picture, String datetime, int user_id) {
    this.d_id = d_id;
    this.details = details;
    this.picture = picture;
    this.datetime = datetime;
    this.user_id = user_id;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }
}
