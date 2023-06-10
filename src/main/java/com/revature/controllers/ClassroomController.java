package com.revature.controllers;

import com.revature.models.Classroom;
import com.revature.services.ClassroomService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ClassroomController {
    private static final ClassroomService crService = new ClassroomService();
    private static final Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    public static void handleInsert(Context ctx) {
        Classroom classroom = ctx.bodyAsClass(Classroom.class);

        int rowsUpdated = crService.insertClassroom(classroom);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result(classroom.getClassName() + " Classroom created for " + classroom.getDescription());
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to create Classroom");
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
            ctx.status(HttpStatus.BAD_REQUEST).result("Classroom with that ID does not exist.");
        } else {
            ctx.json(classroom);
        }
    }

    public static void handleUpdate(Context ctx) {
        Classroom classroom = ctx.bodyAsClass(Classroom.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        int rowsUpdated = crService.updateClassName(classroom.getClassName(), id);
        if (rowsUpdated > 0) {
            ctx.status(200).result("Update Successful!");
            logger.info("Successfully Updated classroom " + id + "'s name to: " + classroom.getClassName());
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to Update Classroom");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Classroom deletedClass = crService.getClassroomById(id);
        if (crService.deleteClassroom(id) == 0 || deletedClass == null) {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to delete. ID did not match a Classroom.");
        } else {
            ctx.result("Successfully deleted the " + deletedClass.getClassName() + " classroom");
        }
    }
}
