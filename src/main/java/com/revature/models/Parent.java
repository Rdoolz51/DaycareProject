package com.revature.models;

public class Parent {
    private int parentId;
    private String parentFn;
    private String parentLn;
    private String debitCardNum;
    private float monthlyDues;

    public Parent(int parentId, String parentFn, String parentLn, String debitCardNum, float monthlyDues) {
        this.parentId = parentId;
        this.parentFn = parentFn;
        this.parentLn = parentLn;
        this.debitCardNum = debitCardNum;
        this.monthlyDues = monthlyDues;
    }

    public Parent(int parentId, String parentFn, String parentLn) {
        this.parentId = parentId;
        this.parentFn = parentFn;
        this.parentLn = parentLn;
    }

    public Parent(int parentId, String parentFn, String parentLn, float monthlyDues) {
        this.parentId = parentId;
        this.parentFn = parentFn;
        this.parentLn = parentLn;
        this.monthlyDues = monthlyDues;
    }

    public Parent(String parentFn, String parentLn, String debitCardNum, float monthlyDues) {
        this.parentFn = parentFn;
        this.parentLn = parentLn;
        this.debitCardNum = debitCardNum;
        this.monthlyDues = monthlyDues;
    }

    public Parent(int parentId, String debitCardNum, float monthlyDues) {
        this.parentId = parentId;
        this.debitCardNum = debitCardNum;
        this.monthlyDues = monthlyDues;
    }

    public Parent(String debitCardNum, int monthlyDues) { //for payments
        this.debitCardNum = debitCardNum;
        this.monthlyDues = monthlyDues;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentFn() {
        return parentFn;
    }

    public void setParentFn(String parentFn) {
        this.parentFn = parentFn;
    }

    public String getParentLn() {
        return parentLn;
    }

    public void setParentLn(String parentLn) {
        this.parentLn = parentLn;
    }

    public String getDebitCardNum() {
        return debitCardNum;

    }

    public void setDebitCardNum(String debitCardNum) {
        this.debitCardNum = debitCardNum;
    }

    public float getMonthlyDues() {
        return monthlyDues;
    }

    public void setMonthlyDues(float monthlyDues) {
        this.monthlyDues = monthlyDues;
    }

    @Override
    public String toString() {
        return "\nParent{" +
                "parentId=" + parentId +
                ", parentFn='" + parentFn + '\'' +
                ", parentLn='" + parentLn + '\'' +
                ", debitCardNum='" + debitCardNum + '\'' +
                ", monthlyDues=" + monthlyDues +
                '}';
    }
}