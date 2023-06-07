package com.revature.controllers;

import com.revature.models.Classroom;
import com.revature.services.ClassroomService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ClassroomController {
    private static final ClassroomService crService = new ClassroomService();

    public static void handleInsert(Context ctx) {
    }

    public static void handleGetAll(Context ctx) {
        ArrayList<Classroom> children = crService.getAllClassrooms();
    }

    public static void handleGetById(Context ctx) {
    }

    public static void handleUpdate(Context ctx) {
    }

    public static void handleDelete(Context ctx) {
    }
}
