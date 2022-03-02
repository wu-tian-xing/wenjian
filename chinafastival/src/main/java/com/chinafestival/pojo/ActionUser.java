package com.chinafestival.pojo;


public class ActionUser {

  private int id;
  private int a_id;
  private int u_id;

  public ActionUser(int id, int a_id, int u_id) {
    this.id = id;
    this.a_id = a_id;
    this.u_id = u_id;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public ActionUser() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getA_id() {
    return a_id;
  }

  public void setA_id(int a_id) {
    this.a_id = a_id;
  }

  public int getU_id() {
    return u_id;
  }

  public void setU_id(int u_id) {
    this.u_id = u_id;
  }
}
