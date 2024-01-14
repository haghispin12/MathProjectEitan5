package com.example.mathprojecteitan5;

import android.net.Uri;

public class userName {
 private String name;
 private int score;
 private int rate;
 private Uri uri;
 private int id;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void Cscore (int scoreType){
  score+=scoreType;
 }

 public int getScore() {
  return score;
 }

 public int getRate() {
  return rate;
 }

 public void setRate(int rate) {
  this.rate = rate;
 }

 public Uri getUri() {
  return uri;
 }

 public void setUri(Uri uri) {
  this.uri = uri;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

}
