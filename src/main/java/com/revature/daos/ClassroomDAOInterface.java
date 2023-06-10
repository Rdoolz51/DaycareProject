package com.revature.daos;

import com.revature.models.Classroom;

import java.util.ArrayList;

public interface ClassroomDAOInterface {

    //get all classrooms
    ArrayList<Classroom> getAllClassrooms();

    //get classroom by id
    Classroom getClassroomById(int id);

    //update classroom name
    int updateClassName(String name, int id);

    //delete classroom
    int deleteClassroom(int id);

    //Insert new classroom
    int insertClassroom(Classroom c);
}
