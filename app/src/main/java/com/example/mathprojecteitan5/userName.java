package com.example.mathprojecteitan5;

import android.graphics.Bitmap;
import android.net.Uri;

public class userName {
 private String name;
 private int score;
 private int rate;
 private Uri uri;
 private long id;
 private Bitmap bitmap;


 public userName(long id, String name,int rate,Bitmap bitmap, int score) {
  this.name = name;
  this.score=score;
  this.rate=rate;
  this.id=id;
  this.bitmap=bitmap;
 }

 public userName() {

 }

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

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public Bitmap getBitmap() {
  return bitmap;
 }

 public void setBitmap(Bitmap bitmap) {
  this.bitmap = bitmap;
 }

 public void setScore(int score) {
  this.score = score;
 }
}
