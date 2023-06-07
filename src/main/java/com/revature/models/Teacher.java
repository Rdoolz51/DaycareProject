package com.revature.models;

public class Teacher {
    private int teacherId;
    private String teacherFn;
    private String teacherLn;
    private int class_id_fk;

    private Classroom classroom;

    public Teacher(int teacherId, String teacherFn, String teacherLn, Classroom classroom) {
        this.teacherId = teacherId;
        this.teacherFn = teacherFn;
        this.teacherLn = teacherLn;
        this.classroom = classroom;
    }

    public Teacher(String teacherFn, String teacherLn, int class_id_fk) { //for inserting into DB
        this.teacherFn = teacherFn;
        this.teacherLn = teacherLn;
        this.class_id_fk = class_id_fk;
    }

    public Teacher(int teacherId, String teacherFn, String teacherLn, int class_id_fk) {
        this.teacherId = teacherId;
        this.teacherFn = teacherFn;
        this.teacherLn = teacherLn;
        this.class_id_fk = class_id_fk;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFn() {
        return teacherFn;
    }

    public void setTeacherFn(String teacherFn) {
        this.teacherFn = teacherFn;
    }

    public String getTeacherLn() {
        return teacherLn;
    }

    public void setTeacherLn(String teacherLn) {
        this.teacherLn = teacherLn;
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
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherFn='" + teacherFn + '\'' +
                ", teacherLn='" + teacherLn + '\'' +
                ", class_id_fk=" + class_id_fk +
                ", classroom=" + classroom +
                '}';
    }
}
