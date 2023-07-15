package com.entity;


public class Comment {
  private int cid;
  private int uid;
  private int aid;
  private int uscore;
  private String cdate;
  private String ccontent;

  //评论对景点是1对1的关系，一个评论中只能放一个景点信息，所以在评论中加入景点实体，用于存放该条评论中存放的景点信息
  private Attraction comment_attraction;

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public int getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }


  public int getUscore() {
    return uscore;
  }

  public void setUscore(int uscore) {
    this.uscore = uscore;
  }


  public String getCdate() {
    return cdate;
  }

  public void setCdate(String cdate) {
    this.cdate = cdate;
  }


  public String getCcontent() {
    return ccontent;
  }

  public void setCcontent(String ccontent) {
    this.ccontent = ccontent;
  }

  public Attraction getComment_attraction() {
    return comment_attraction;
  }

  public void setComment_attraction(Attraction comment_attraction) {
    this.comment_attraction = comment_attraction;
  }
  @Override
  public String toString() {
    return "Comment{" +
            "cid=" + cid +
            ", uid=" + uid +
            ", aid=" + aid +
            ", uscore=" + uscore +
            ", cdate='" + cdate + '\'' +
            ", ccontent='" + ccontent + '\'' +
            ", attraction=" + comment_attraction +
            '}';
  }

}
