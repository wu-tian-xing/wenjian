package com.chinafestival.pojo;


public class Review {

  private int r_id;
  private String dateime;
  private int d_id;
  private String details;
  private int u_id;
  private int praise;

  public Review() {
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public int getR_id() {
    return r_id;
  }

  public void setR_id(int r_id) {
    this.r_id = r_id;
  }

  public String getDateime() {
    return dateime;
  }

  public void setDateime(String dateime) {
    this.dateime = dateime;
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

  public int getU_id() {
    return u_id;
  }

  public void setU_id(int u_id) {
    this.u_id = u_id;
  }

  public int getPraise() {
    return praise;
  }

  public void setPraise(int praise) {
    this.praise = praise;
  }
}
