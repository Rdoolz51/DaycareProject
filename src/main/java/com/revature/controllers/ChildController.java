package com.revature.controllers;

import com.revature.daos.ChildDAO;
import com.revature.models.Child;
import com.revature.services.ChildService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ChildController {
    private static final ChildService cService = new ChildService(new ChildDAO());

    private static final Logger logger = LoggerFactory.getLogger(ChildController.class);


    public static void handleInsert(Context ctx) {

        Child child = ctx.bodyAsClass(Child.class);

        int rowsUpdated = cService.insertChild(child);

        if (rowsUpdated == 1) {
            ctx.status(HttpStatus.CREATED).result(child.getChildFn() + " " + child.getChildLn() + " Added to the Database!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to create Child");
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
            ctx.status(HttpStatus.BAD_REQUEST).result("Child with that ID does not exist.");
            logger.warn("Tried to Delete child using an ID that could not be found");
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
            logger.info("Updated Child with ID " + id + " successfully!");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to update Child");
        }
    }

    public static void handleDelete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Child deletedChild = cService.getChildById(id);
        if (deletedChild == null || cService.deleteChild(id) == 0) {
            ctx.status(HttpStatus.BAD_REQUEST).result("Failed to delete. ID did not match a Child.");
        } else {
            ctx.result("Successfully deleted " + deletedChild.getChildFn() + " " + deletedChild.getChildLn());
        }
    }
}
