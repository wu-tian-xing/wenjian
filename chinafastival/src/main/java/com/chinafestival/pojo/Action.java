package com.chinafestival.pojo;


import javax.xml.crypto.Data;
import java.util.Date;

public class Action {

  private int a_id;
  private String informatin;
  private String title;
  private String sort;
  private String starttime;
  private String endtime;
  private String place;
  private String needpeople;
  private String way;
  private int joinpeople;
  private String picture;
  private int statecode;

  @Override
  public String toString() {
    return super.toString();
  }

  public Action() {
  }


  public int getA_id() {
    return a_id;
  }

  public void setA_id(int a_id) {
    this.a_id = a_id;
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

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
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

  public String getNeedpeople() {
    return needpeople;
  }

  public void setNeedpeople(String needpeople) {
    this.needpeople = needpeople;
  }

  public String getWay() {
    return way;
  }

  public void setWay(String way) {
    this.way = way;
  }

  public Action(int a_id, String informatin, String title, String sort, String starttime, String endtime, String place, String needpeople, String way, int joinpeople, int u_id, String picture, int statecode) {
    this.a_id = a_id;
    this.informatin = informatin;
    this.title = title;
    this.sort = sort;
    this.starttime = starttime;
    this.endtime = endtime;
    this.place = place;
    this.needpeople = needpeople;
    this.way = way;
    this.joinpeople = joinpeople;
    this.picture = picture;
    this.statecode = statecode;
  }

  public int getJoinpeople() {
    return joinpeople;
  }

  public void setJoinpeople(int joinpeople) {
    this.joinpeople = joinpeople;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public int getStatecode() {
    return statecode;
  }

  public void setStatecode(int statecode) {
    this.statecode = statecode;
  }
}
