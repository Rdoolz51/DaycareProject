package com.revature.controllers;

import com.revature.models.Classroom;
import com.revature.models.Teacher;
import com.revature.services.ClassroomService;
import com.revature.services.TeacherService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TeacherController {
    private static final TeacherService tService = new TeacherService();
    private static final ClassroomService crService = new ClassroomService();

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    public static void handleInsert(Context ctx) {
        Teacher teacher = ctx.bodyAsClass(Teacher.class);
        //check if classroom exists
        Classroom classroom = crService.getClassroomById(teacher.getClass_id_fk());

        int rowsUpdated = tService.insertTeacher(teacher);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result(teacher.getTeacherFn() + " " + teacher.getTeacherLn() + " Added to the Database!");
        } else if (rowsUpdated == 0 && classroom == null) {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to add teacher because Classroom does not exist!");
            logger.warn("Failed to add Teacher. No classroom with the id of " + teacher.getClass_id_fk() + " exists.");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to add teacher to database.");
        }
    }

    public static void handleGetAll(Context ctx) {
        ArrayList<Teacher> teachers = tService.getAllTeachers();
        ctx.json(teachers);
    }

    public static void handleGetById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Teacher teacher = tService.getTeacherById(id);
        if (tService.getTeacherById(id) == null) {
            ctx.status(HttpStatus.BAD_REQUEST).result("Teacher with that ID does not exist.");
        } else {
            ctx.json(teacher);
        }
    }

    public static void handleUpdate(Context ctx) {
        Teacher teacher = ctx.bodyAsClass(Teacher.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        int rowsUpdated = tService.updateTeacher(teacher.getTeacherFn(), teacher.getTeacherLn(), teacher.getClass_id_fk(), id);

        if (rowsUpdated > 0) {
            ctx.status(200).result("Update Successful!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to Update Teacher");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Teacher deletedTeacher = tService.getTeacherById(id);
        if (tService.deleteTeacher(id) == 0 || deletedTeacher == null) {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to delete. ID did not match a Teacher.");
            logger.warn("Failed to delete Teacher. The ID " + id + " did not match any teachers in the database!");
        } else {
            ctx.result("Successfully deleted " + deletedTeacher.getTeacherFn() + " " + deletedTeacher.getTeacherLn());
        }
    }
}
