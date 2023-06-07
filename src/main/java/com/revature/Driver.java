package com.revature;

import com.revature.daos.ChildDAO;
import com.revature.daos.ClassroomDAO;
import com.revature.daos.TeacherDAO;
import com.revature.models.Child;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTED!");
        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED!");
            e.printStackTrace();
        }

        ClassroomDAO cDao = new ClassroomDAO();
        ChildDAO chDao = new ChildDAO();
        TeacherDAO tDao = new TeacherDAO();
        
        System.out.println(cDao.getAllClassrooms());
        System.out.println(chDao.getAllChildren());
        System.out.println(tDao.getAllTeachers());
    }
}
