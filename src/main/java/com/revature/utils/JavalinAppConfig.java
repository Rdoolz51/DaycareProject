package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.ChildController;
import com.revature.controllers.TeacherController;
import com.revature.controllers.ClassroomController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig {
    //This is the class for all Javalin configurations

    Gson gson = new GsonBuilder().create();

    JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            //routes will declare all our possible paths
            .routes(() -> {
                //each path will allow to group like methods
                path("children", () -> {
                    //Declare my routes and methods super quickly
                    get(ChildController::handleGetAll);
                    post(ChildController::handleInsert);
                    path("{id}", () -> {
                        get(ChildController::handleGetById);
                        put(ChildController::handleUpdate);
                        delete(ChildController::handleDelete);
                    });
                });
                path("teachers", () -> {
                    get(TeacherController::handleGetAll);
                    post(TeacherController::handleInsert);
                    path("{id}", () -> {
                        get(TeacherController::handleGetById);
                        put(TeacherController::handleUpdate);
                        delete(TeacherController::handleDelete);
                    });
                });
                path("classrooms", () -> {
                    get(ClassroomController::handleGetAll);
                    post(ClassroomController::handleInsert);
                    path("{id}", () -> {
                        get(ClassroomController::handleGetById);
                        put(ClassroomController::handleUpdate);
                        delete(ClassroomController::handleDelete);
                    });
                });
            });

    public void start(int port) {
        app.start(port);
    }
}