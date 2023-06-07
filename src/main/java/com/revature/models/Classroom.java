package com.revature.models;

public class Classroom {
    private int classId;
    private String className;

    private String description;


    public Classroom(String className) {
        this.className = className;
    }

    public Classroom(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Classroom(int classId, String className, String description) {
        this.classId = classId;
        this.className = className;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
