package com.example.mathprojecteitan5;

import com.example.mathprojecteitan5.PersonColor;

public class Character {
 String Name;
 PersonColor HairColor;
 PersonColor SkinColor;
 PersonColor EyeColor;
 boolean BigNose;
 boolean WearingHat;
 boolean HasGlasses;
 boolean HasBeard;
 boolean HasMoustache;
 boolean isMale;
 boolean LongHair;
 int picture;

 public Character(String Name,boolean isMale,PersonColor HairColor,PersonColor SkinColor,PersonColor EyeColor,boolean BigNose,boolean WearingHat,boolean HasGlasses,boolean HasBeard,boolean HasMoustache, boolean longHair,int picture){
  this.Name=Name;
  this.HairColor=HairColor;
  this.SkinColor=SkinColor;
  this.EyeColor=EyeColor;
  this.BigNose=BigNose;
  this.WearingHat=WearingHat;
  this.HasGlasses=HasGlasses;
  this.HasBeard=HasBeard;
  this.HasMoustache=HasMoustache;
  this.isMale=isMale;
  this.LongHair=longHair;
  this.picture=picture;
 }

 public int getPicture() {
  return picture;
 }

 public void setPicture(int picture) {
  this.picture = picture;
 }
}
