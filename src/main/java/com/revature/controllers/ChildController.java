package com.revature.controllers;

import com.revature.models.Child;
import com.revature.services.ChildService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.ArrayList;

public class ChildController {
    private static final ChildService cService = new ChildService();

    public static void handleInsert(Context ctx) {

        Child child = ctx.bodyAsClass(Child.class);

        int rowsUpdated = cService.insertChild(child);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result("Child Created!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to create");
        }
    }

    public static void handleGetAll(Context ctx) {
        ArrayList<Child> children = cService.getAllChildren();
        ctx.json(children);
    }

    public static void handleGetById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Child child = cService.getChildById(id);
        if (cService.getChildById(id) == null) {
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.json(child);
        }
    }

    public static void handleUpdate(Context ctx) {
        Child child = ctx.bodyAsClass(Child.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        int rowsUpdated = cService.updateChild(child.getChildFn(), child.getChildLn(), child.getChildDob(), child.getClass_id_fk(), id);
        if (rowsUpdated > 0) {
            ctx.status(200).result("Update Successful!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to update Child");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (cService.deleteChild(id) == 0) {
            ctx.status(HttpStatus.BAD_REQUEST);
        } else {
            ctx.result("Successfully deleted child");
        }
    }
}
