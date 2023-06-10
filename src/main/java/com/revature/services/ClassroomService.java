package com.revature.services;

import com.revature.daos.ClassroomDAOInterface;
import com.revature.daos.ClassroomDAO;
import com.revature.models.Classroom;

import java.util.ArrayList;

public class ClassroomService {

    private final ClassroomDAOInterface cDao = new ClassroomDAO();

    public int insertClassroom(Classroom c) {
        return cDao.insertClassroom(c);
    }

    public ArrayList<Classroom> getAllClassrooms() {
        return cDao.getAllClassrooms();
    }

    public Classroom getClassroomById(int id) {
        return cDao.getClassroomById(id);
    }

    public int updateClassName(String name, int id) {
        return cDao.updateClassName(name, id);
    }

    public int deleteClassroom(int id) {
        return cDao.deleteClassroom(id);
    }

}
