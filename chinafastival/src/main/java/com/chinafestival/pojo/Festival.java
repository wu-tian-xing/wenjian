package com.chinafestival.pojo;


public class Festival {

  private int festival_id;
  private String festival_name;

  public Festival() {
  }

  public Festival(int festival_id, String festival_name) {
    this.festival_id = festival_id;
    this.festival_name = festival_name;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public int getFestival_id() {
    return festival_id;
  }

  public void setFestival_id(int festival_id) {
    this.festival_id = festival_id;
  }

  public String getFestival_name() {
    return festival_name;
  }

  public void setFestival_name(String festival_name) {
    this.festival_name = festival_name;
  }
}
