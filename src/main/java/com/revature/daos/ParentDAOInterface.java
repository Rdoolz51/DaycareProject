package com.revature.daos;

import com.revature.models.Parent;

import java.util.ArrayList;

public interface ParentDAOInterface {
    //get all Parents
    ArrayList<Parent> getAllParents();

    //find parent by kids id
    Parent getParentByChildId(int id);

    //Create a parent
    int insertParent(Parent p);

    //Update a Parent
    boolean updateParent(String firstName, String lastName, int child_id_fk, int id);

    //update parent paymentMethod
    boolean updateParentPayment(int id, String debitCardNum);

    //Delete a Parent
    int deleteChild(int id);
}
