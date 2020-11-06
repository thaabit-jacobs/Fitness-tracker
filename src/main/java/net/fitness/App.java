package net.fitness;

import static spark.Spark.*;

import com.google.gson.Gson;
import net.fitness.controller.ExerciseController;
import net.fitness.model.Exercise;
import net.fitness.service.ExerciseService;
import net.fitness.types.ExerciseType;
import net.fitness.types.Name;
import net.fitness.types.StatusResponse;
import net.fitness.util.StandardResponse;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        staticFiles.location("/public");
        new ExerciseController(new ExerciseService());
    }
}
