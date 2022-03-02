package com.chinafestival.pojo;


public class ReviewView {

  private String u_name;
  private String headphoto;
  private int r_id;
  private String dateime;
  private int d_id;
  private String details;


  public ReviewView() {
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public String getHeadphoto() {
    return headphoto;
  }

  public void setHeadphoto(String headphoto) {
    this.headphoto = headphoto;
  }


  public String getU_name() {
    return u_name;
  }

  public void setU_name(String u_name) {
    this.u_name = u_name;
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

}
