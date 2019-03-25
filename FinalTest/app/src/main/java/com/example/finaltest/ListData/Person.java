package com.example.finaltest.ListData;

public class Person {

    private String fisrtName;
    private String lastName;
    private int age;
    private int imgId;

    public Person(String fisrtName, String lastName, int age, int imgId) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.age = age;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
