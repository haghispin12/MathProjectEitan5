package com.example.mathprojecteitan5;

public class Request {

  public String idGame;
  public int question;
  public String sender;
  public int answer;
  String characterP1;
  String characterP2;
  public int currentUp;


  public Request(String idGame, String sender) {
    this.idGame = idGame;
    this.question = 0;
    this.sender = sender;
    this.answer = 0;
    this.currentUp = 24;
    this.characterP1="";
    this.characterP2="";
  }


  public String getIdGame() {
    return idGame;
  }

  public void setIdGame(String idGame) {
    this.idGame = idGame;
  }

  public int getQuestion() {
    return question;
  }

  public void setQuestion(int question) {
    this.question = question;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  public String getCharacter1() {
    return characterP1;
  }

  public void setCharacter1(String character1) {
    this.characterP1 = character1;
  }

  public String getCharacter2() {
    return characterP2;
  }

  public void setCharacter2(String character2) {
    this.characterP2 = character2;
  }

  public int getCurrentUp() {
    return currentUp;
  }

  public void setCurrentUp(int currentUp) {
    this.currentUp = currentUp;
  }
}
