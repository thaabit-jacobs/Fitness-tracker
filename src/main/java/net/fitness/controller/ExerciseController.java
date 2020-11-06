package net.fitness.controller;

import static spark.Spark.*;

import com.github.jknack.handlebars.Handlebars;
import com.google.gson.Gson;

import net.fitness.model.Exercise;
import net.fitness.service.ExerciseService;
import net.fitness.types.ExerciseType;
import net.fitness.types.Name;
import net.fitness.types.StatusResponse;
import net.fitness.util.StandardResponse;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class ExerciseController {

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public ExerciseController(final ExerciseService  es){


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("exerciseNameMonday", Name.DEADLIFT.toString());
            model.put("exerciseNameTuesday", Name.ROW.toString());
            model.put("exerciseNameWednesday", Name.SINGLEHANDROW.toString());
            model.put("exerciseNameThursday", Name.DEADLIFT.toString());
            model.put("exerciseNameFriday", Name.ROW.toString());

            return render(model, "index.hbs");
        });

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();


            return render(model, "form.hbs");
        });

        post("/exercise", (request, response) -> {
            response.type("application/json");

            Exercise exercise = new Gson().fromJson(request.body(), Exercise.class);

            es.insertExercise(exercise);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/exercise", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(es.selectAllExercises())));
        });

        get("/exercise/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(es.selectExercise(Integer.valueOf(request.params(":id"))))));
        });

        put("/exercise/:id", (request, response) -> {
            response.type("application/json");
            Exercise toEdit = new Gson().fromJson(request.body(), Exercise.class);
            es.updateExercise(toEdit);

            if (toEdit != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS,new Gson()
                                .toJsonTree(toEdit)));
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR,new Gson()
                                .toJson("Exercise not found")));
            }
        });

        delete("/exercise/:id", (request, response) -> {
            response.type("application/json");
            es.deleteExercise(Integer.valueOf(request.params(":id")));
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, "exercise deleted"));
        });
    }
}
