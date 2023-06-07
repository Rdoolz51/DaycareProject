package com.revature.models;

public class Classroom {
    private int classId;
    private String className;


    public Classroom(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
