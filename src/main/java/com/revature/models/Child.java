package com.revature.models;

import com.revature.utils.AgeFinderUtil;

import java.sql.Date;
import java.time.Period;

public class Child {

    private int childId;
    private String childFn;
    private String childLn;
    private int class_id_fk;
    private Date childDob;
    private Classroom classroom;

    public Child(int childId, String childFn, String childLn, Date childDob) {
        this.childId = childId;
        this.childFn = childFn;
        this.childLn = childLn;
        this.childDob = childDob;

    }

    public Child(int childId, String childFn, String childLn, Date childDob, Classroom classroom) {
        this.childId = childId;
        this.childFn = childFn;
        this.childLn = childLn;
        this.childDob = childDob;
        this.classroom = classroom;
    }


    public Child(String childFn, String childLn, Date childDob, int class_id_fk) { //for inserting into DB
        this.childFn = childFn;
        this.childLn = childLn;
        this.childDob = childDob;
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

    public Period getChildAge() {
        return AgeFinderUtil.getAge(this.childDob);

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

    public Date getChildDob() {
        return childDob;
    }

    public void setChildDob(Date childDob) {
        this.childDob = childDob;
    }

    @Override
    public String toString() {
        return "\nChild{" +
                "childId=" + childId +
                ", childFn='" + childFn + '\'' +
                ", childLn='" + childLn + '\'' +
                ", class_id_fk=" + class_id_fk +
                ", childDob='" + childDob + '\'' +
                ", classroom=" + classroom + '\'' +
                ", childAge=" + String.format("%.2f", getChildAge().toTotalMonths() / 12.0f) +
                '}';
    }
}
