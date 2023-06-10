package com.revature.daos;

import com.revature.models.Teacher;

import java.util.ArrayList;

public interface TeacherDAOInterface {
    //get all teachers
    ArrayList<Teacher> getAllTeachers();

    //get a teacher by ID
    Teacher getTeacherById(int id);

    //Insert a new Teacher
    int insertTeacher(Teacher t);

    //Delete a Teacher
    int deleteTeacher(int id);

    //Update Teacher
    int updateTeacher(String firstName, String lastName, int class_id_fk, int id);
}
