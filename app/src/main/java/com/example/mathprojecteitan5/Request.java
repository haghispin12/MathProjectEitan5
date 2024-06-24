package com.example.mathprojecteitan5;

public class Request {

  public String idGame;
  public int question;
  public String sender;
  public int answer;
  public int currentUp;


  public Request(String idGame, String sender) {
    this.idGame = idGame;
    this.question = 0;
    this.sender = sender;
    this.answer = 0;
    this.currentUp = 24;
  }
}
