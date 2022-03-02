package com.chinafestival.pojo;



public class DynameReview {

  private int d_id;
  private String details;
  private String picture;
  private String datetime;
  private int user_id;
  private int num_review;
  private int praise;
  private int r_id;

  public DynameReview(int d_id, String details, String picture, String datetime, int user_id, int num_review, int praise, int r_id, String d_dateime, String d_details, int u_id) {
    this.d_id = d_id;
    this.details = details;
    this.picture = picture;
    this.datetime = datetime;
    this.user_id = user_id;
    this.num_review = num_review;
    this.praise = praise;
    this.r_id = r_id;
    this.d_dateime = d_dateime;
    this.d_details = d_details;
    this.u_id = u_id;
  }

  private String d_dateime;
  private String d_details;
  private int u_id;

  public DynameReview() {
  }

  @Override
  public String toString() {
    return super.toString();
  }




  public int getD_id() {
    return d_id;
  }

  public void setD_id(int d_id) {
    this.d_id = d_id;
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

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getNum_review() {
    return num_review;
  }

  public void setNum_review(int num_review) {
    this.num_review = num_review;
  }

  public int getPraise() {
    return praise;
  }

  public void setPraise(int praise) {
    this.praise = praise;
  }

  public int getR_id() {
    return r_id;
  }

  public void setR_id(int r_id) {
    this.r_id = r_id;
  }

  public String getD_dateime() {
    return d_dateime;
  }

  public void setD_dateime(String d_dateime) {
    this.d_dateime = d_dateime;
  }

  public String getD_details() {
    return d_details;
  }

  public void setD_details(String d_details) {
    this.d_details = d_details;
  }

  public int getU_id() {
    return u_id;
  }

  public void setU_id(int u_id) {
    this.u_id = u_id;
  }
}
