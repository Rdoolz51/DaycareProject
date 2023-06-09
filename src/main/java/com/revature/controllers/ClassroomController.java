package com.revature.controllers;

import com.revature.models.Classroom;
import com.revature.services.ClassroomService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.ArrayList;

public class ClassroomController {
    private static final ClassroomService crService = new ClassroomService();

    public static void handleInsert(Context ctx) {
        Classroom classroom = ctx.bodyAsClass(Classroom.class);

        int rowsUpdated = crService.insertClassroom(classroom);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result("Classroom Created!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to create");
        }
    }

    public static void handleGetAll(Context ctx) {

        ArrayList<Classroom> classrooms = crService.getAllClassrooms();
        ctx.json(classrooms);
    }

    public static void handleGetById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Classroom classroom = crService.getClassroomById(id);
        if (crService.getClassroomById(id) == null) {
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.json(classroom);
        }
    }

    public static void handleUpdate(Context ctx) {
        Classroom classroom = ctx.bodyAsClass(Classroom.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean updateSuccessful = crService.updateClassName(classroom.getClassName(), id);
        if (updateSuccessful) {
            ctx.status(200).result("Update Successful!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to Update Classroom");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (crService.deleteClassroom(id) == 0) {
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.result("Successfully deleted classroom");
        }
    }
}
