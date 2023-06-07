package com.revature.services;

import com.revature.daos.TeacherDAO;
import com.revature.daos.TeacherDAOInterface;
import com.revature.models.Teacher;

import java.util.ArrayList;

public class TeacherService {
    private final TeacherDAOInterface tDao = new TeacherDAO();

    public int insertTeacher(Teacher t) {
        return tDao.insertTeacher(t);
    }

    public ArrayList<Teacher> getAllTeachers() {
        return tDao.getAllTeachers();
    }

    public Teacher getTeacherById(int id) {
        return tDao.getTeacherById(id);
    }

    public boolean updateTeacher(String firstName, String lastName, int class_id_fk, int id) {
        return tDao.updateTeacher(firstName, lastName, class_id_fk, id);
    }

    public int deleteTeacher(int id) {
        return tDao.deleteTeacher(id);
    }

}
