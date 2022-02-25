package com.example.rankapi.Rank;

import javax.persistence.*;

@Entity
@Table(name = "rank")
public class Rank {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String username;
  private long score;
  private String gametitle;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public String getGametitle() {
    return gametitle;
  }

  public void setGametitle(String gametitle) {
    this.gametitle = gametitle;
  }

}
