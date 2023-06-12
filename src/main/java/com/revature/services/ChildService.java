package com.revature.services;

import com.revature.daos.ChildDAO;
import com.revature.daos.ChildDAOInterface;
import com.revature.models.Child;

import java.sql.Date;
import java.util.ArrayList;

public class ChildService {

    //    private final ChildDAOInterface chDAO = new ChildDAO();
    private final ChildDAOInterface chDao;

    public ChildService(ChildDAOInterface chDao) {
        this.chDao = chDao;
    }


    public int insertChild(Child c) {
        ChildDAO chDAO = new ChildDAO();
        return chDAO.insertChild(c);
    }

    public ArrayList<Child> getAllChildren() {
        ChildDAO chDAO = new ChildDAO();
        return chDAO.getAllChildren();
    }

    public Child getChildById(int id) {
        ChildDAO chDAO = new ChildDAO();
        if (id > 0) {
            return chDAO.getChildById(id);
        }
        return null;
    }

    public int updateChild(String firstName, String lastName, Date childDob, int class_id_fk, int id) {
        ChildDAO chDAO = new ChildDAO();
        return chDAO.updateChild(firstName, lastName, childDob, class_id_fk, id);
    }

    public int deleteChild(int id) {
        ChildDAO chDAO = new ChildDAO();
        return chDAO.deleteChild(id);
    }
}
