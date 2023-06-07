package com.revature.controllers;

import com.revature.models.Teacher;
import com.revature.services.TeacherService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class TeacherController {
    private static final TeacherService tService = new TeacherService();

    public static void handleInsert(Context ctx) {
    }

    public static void handleGetAll(Context ctx) {
        ArrayList<Teacher> teachers = tService.getAllTeachers();
    }

    public static void handleGetById(Context ctx) {
    }

    public static void handleUpdate(Context ctx) {
    }

    public static void handleDelete(Context ctx) {
    }
}
