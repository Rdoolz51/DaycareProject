package com.revature.controllers;

import com.revature.models.Child;
import com.revature.services.ChildService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ChildController {
    private static final ChildService cService = new ChildService();

    public static void handleInsert(Context ctx) {
    }

    public static void handleGetAll(Context ctx) {
        ArrayList<Child> children = cService.getAllChildren();
    }

    public static void handleGetById(Context ctx) {
    }

    public static void handleUpdate(Context ctx) {
    }

    public static void handleDelete(Context ctx) {
    }
}
