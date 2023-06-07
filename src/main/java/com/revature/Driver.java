package com.revature;

import com.revature.daos.ChildDAO;
import com.revature.daos.ClassroomDAO;
import com.revature.daos.TeacherDAO;
import com.revature.models.Child;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.JavalinAppConfig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
//        //Create a new instance of the Javalin Config Class
        JavalinAppConfig app = new JavalinAppConfig();
//
//        //Start the app with app.start
        app.start(7070);

//        chDao.insertChild(new Child("Johnathan", "Dooley", Date.valueOf("2022-04-27"), 1));
//        chDao.updateChild("Johnathan", "Dooley", Date.valueOf("2022-04-27"), 2, 1);
//        chDao.insertChild(new Child("Maddox", "Dooley", Date.valueOf("2019-08-01"), 4));
//        System.out.println(cDao.getAllClassrooms());
//        System.out.println(chDao.getAllChildren());
//        System.out.println(chDao.getChildById(1).getChildAge().toTotalMonths() / 12.0); //get age in double
//        System.out.println(tDao.getAllTeachers());
    }
}
