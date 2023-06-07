package com.revature.services;

import com.revature.daos.ChildDAO;
import com.revature.daos.ChildDAOInterface;
import com.revature.models.Child;

import java.sql.Date;
import java.util.ArrayList;

public class ChildService {

    private final ChildDAOInterface chDAO = new ChildDAO();

    public int insertChild(Child c) {
        return chDAO.insertChild(c);
    }

    public ArrayList<Child> getAllChildren() {
        return chDAO.getAllChildren();
    }

    public Child getChildById(int id) {
        return chDAO.getChildById(id);
    }

    public boolean updateChild(String firstName, String lastName, Date childDob, int class_id_fk, int id) {
        return chDAO.updateChild(firstName, lastName, childDob, class_id_fk, id);
    }

    public int deleteChild(int id) {
        return chDAO.deleteChild(id);
    }
}
