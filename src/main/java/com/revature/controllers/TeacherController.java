package com.revature.controllers;

import com.revature.models.Child;
import com.revature.models.Classroom;
import com.revature.models.Teacher;
import com.revature.services.TeacherService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.ArrayList;

public class TeacherController {
    private static final TeacherService tService = new TeacherService();

    public static void handleInsert(Context ctx) {
        Teacher teacher = ctx.bodyAsClass(Teacher.class);

        int rowsUpdated = tService.insertTeacher(teacher);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result("Teacher Created!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to create");
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
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.json(teacher);
        }
    }

    public static void handleUpdate(Context ctx) {
        Teacher teacher = ctx.bodyAsClass(Teacher.class);

        boolean updateSuccessful = tService.updateTeacher(teacher.getTeacherFn(), teacher.getTeacherLn(), teacher.getClass_id_fk(), teacher.getTeacherId());

        if (updateSuccessful) {
            ctx.status(200).result("Update Successful!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to Update Teacher");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (tService.deleteTeacher(id) == 0) {
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.result("Successfully deleted teacher");
        }
    }
}
