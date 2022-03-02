package com.chinafestival.pojo;


import java.util.Date;

public class ActionView {

  private String informatin;
  private String title;
  private String starttime;
  private  String endtime;
  private String place;
  private String joinpeople;
  private int a_id;
  private String picture;
  private int u_id;
  private int statecode;
  private String sort;
  private String way;
  private String needpeople;

  public ActionView() {
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public ActionView(String informatin, String title, String starttime, String endtime, String place, String joinpeople, int a_id, String picture, int u_id, int statecode, String sort, String way, String needpeople) {
    this.informatin = informatin;
    this.title = title;
    this.starttime = starttime;
    this.endtime = endtime;
    this.place = place;
    this.joinpeople = joinpeople;
    this.a_id = a_id;
    this.picture = picture;
    this.u_id = u_id;
    this.statecode = statecode;
    this.sort = sort;
    this.way = way;
    this.needpeople = needpeople;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getWay() {
    return way;
  }

  public void setWay(String way) {
    this.way = way;
  }

  public String getNeedpeople() {
    return needpeople;
  }

  public void setNeedpeople(String needpeople) {
    this.needpeople = needpeople;
  }



  public int getStatecode() {
    return statecode;
  }

  public void setStatecode(int statecode) {
    this.statecode = statecode;
  }



  public int getU_id() {
    return u_id;
  }

  public void setU_id(int u_id) {
    this.u_id = u_id;
  }

  public String getInformatin() {
    return informatin;
  }

  public void setInformatin(String informatin) {
    this.informatin = informatin;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStarttime() {
    return starttime;
  }

  public void setStarttime(String starttime) {
    this.starttime = starttime;
  }

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getJoinpeople() {
    return joinpeople;
  }

  public void setJoinpeople(String joinpeople) {
    this.joinpeople = joinpeople;
  }

  public int getA_id() {
    return a_id;
  }

  public void setA_id(int a_id) {
    this.a_id = a_id;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
}
