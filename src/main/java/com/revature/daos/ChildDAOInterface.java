package com.revature.daos;

import com.revature.models.Child;

import java.util.ArrayList;

public interface ChildDAOInterface {

    //get all children
    ArrayList<Child> getAllChildren();

    //get a child by ID
    Child getChildById(int id);

    //Insert a new Child
    int insertChild(Child c);

    //Delete a Child
    int deleteChild(int id);

    //Update Child
    boolean updateChild(String firstName, String lastName, int age, int class_id_fk, int id);
}
