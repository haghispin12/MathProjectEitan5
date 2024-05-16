package com.example.mathprojecteitan5;

public class ACharacter {
 private String Name;
 private PersonColor HairColor;
 private PersonColor SkinColor;
 private PersonColor EyeColor;
 private boolean BigNose;
 private boolean WearingHat;
 private boolean HasGlasses;
 private boolean HasBeard;
 private boolean HasMoustache;
 private boolean isMale;
 private boolean LongHair;
 private int picture;

 public ACharacter(String Name, boolean isMale, PersonColor HairColor, PersonColor SkinColor, PersonColor EyeColor, boolean BigNose, boolean WearingHat, boolean HasGlasses, boolean HasBeard, boolean HasMoustache, boolean longHair, int picture){
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

 public ACharacter(){
  this.Name="Name";
  this.HairColor=PersonColor.WHITE;
  this.SkinColor=PersonColor.WHITE;
  this.EyeColor=PersonColor.BLUE;
  this.BigNose=true;
  this.WearingHat=true;
  this.HasGlasses=true;
  this.HasBeard=true;
  this.HasMoustache=true;
  this.isMale=true;
  this.LongHair=true;
  this.picture=R.drawable.userpic;
 }

 public int getPicture() {
  return picture;
 }

 public void setPicture(int picture) {
  this.picture = picture;
 }


 public String getName() {
  return Name;
 }

 public void setName(String name) {
  Name = name;
 }

 public PersonColor getHairColor() {
  return HairColor;
 }

 public void setHairColor(PersonColor hairColor) {
  HairColor = hairColor;
 }

 public PersonColor getSkinColor() {
  return SkinColor;
 }

 public void setSkinColor(PersonColor skinColor) {
  SkinColor = skinColor;
 }

 public PersonColor getEyeColor() {
  return EyeColor;
 }

 public void setEyeColor(PersonColor eyeColor) {
  EyeColor = eyeColor;
 }

 public boolean isBigNose() {
  return BigNose;
 }

 public void setBigNose(boolean bigNose) {
  BigNose = bigNose;
 }

 public boolean isWearingHat() {
  return WearingHat;
 }

 public void setWearingHat(boolean wearingHat) {
  WearingHat = wearingHat;
 }

 public boolean isHasGlasses() {
  return HasGlasses;
 }

 public void setHasGlasses(boolean hasGlasses) {
  HasGlasses = hasGlasses;
 }

 public boolean isHasBeard() {
  return HasBeard;
 }

 public void setHasBeard(boolean hasBeard) {
  HasBeard = hasBeard;
 }

 public boolean isHasMoustache() {
  return HasMoustache;
 }

 public void setHasMoustache(boolean hasMoustache) {
  HasMoustache = hasMoustache;
 }

 public boolean isMale() {
  return isMale;
 }

 public void setMale(boolean male) {
  isMale = male;
 }

 public boolean isLongHair() {
  return LongHair;
 }

 public void setLongHair(boolean longHair) {
  LongHair = longHair;
 }
}
