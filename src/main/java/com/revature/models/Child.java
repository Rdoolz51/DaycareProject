package com.revature.models;

import com.revature.utils.AgeFinderUtil;

import java.time.LocalDate;

import static com.revature.utils.AgeFinderUtil.getAge;

public class Child {

    private int childId;
    private String childFn;
    private String childLn;
    //private static String dateOfBirth; // YYYY-MM-DD Format very important
    //public static int childAge = AgeFinderUtil.getAge(LocalDate.parse(dateOfBirth)); //Uses AgeFinderUtil to calculate age in years based on DOB and Current Date.
    private int childAge;
    private int class_id_fk;

    private Classroom classroom;


    public Child(int childId, String childFn, String childLn, int childAge) {
        this.childId = childId;
        this.childFn = childFn;
        this.childLn = childLn;
        this.childAge = childAge;
    }

    public Child(int childId, String childFn, String childLn, int childAge, Classroom classroom) {
        this.childId = childId;
        this.childFn = childFn;
        this.childLn = childLn;
        this.childAge = childAge;
        this.classroom = classroom;
    }

    public Child(String childFn, String childLn, int childAge, int class_id_fk) { //for inserting into DB
        this.childFn = childFn;
        this.childLn = childLn;
        this.childAge = childAge;
        this.class_id_fk = class_id_fk;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildFn() {
        return childFn;
    }

    public void setChildFn(String childFn) {
        this.childFn = childFn;
    }

    public String getChildLn() {
        return childLn;
    }

    public void setChildLn(String childLn) {
        this.childLn = childLn;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public int getClass_id_fk() {
        return class_id_fk;
    }

    public void setClass_id_fk(int class_id_fk) {
        this.class_id_fk = class_id_fk;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }


    @Override
    public String toString() {
        return "Child{" +
                "childId=" + childId +
                ", childFn='" + childFn + '\'' +
                ", childLn='" + childLn + '\'' +
                ", childAge=" + childAge +
                ", class_id_fk=" + class_id_fk +
                ", classroom=" + classroom +
                '}';
    }
}
