package net.fitness.service;

import net.fitness.doa.ExerciseDoa;
import net.fitness.doa.ExerciseDoaImpl;
import net.fitness.mappers.ExerciseMapper;
import net.fitness.model.Exercise;

import java.util.List;

public class ExerciseService {
    private final ExerciseDoaImpl edi = new ExerciseDoaImpl();


    public boolean insertExercise(Exercise exercise) {
        return edi.insertExercise(exercise);
    }

    public Exercise selectExercise(int id) {
        return edi.selectExercise(id);
    }

    public List<Exercise> selectAllExercises() {
        return edi.selectAllExercises();
    }

    public boolean updateExercise(Exercise exercise) {
        return edi.updateExercise(exercise);
    }

    public boolean deleteExercise(int id) {
        return edi.deleteExercise(id);
    }

    public boolean deleteAllExercise() {
        return edi.deleteAllExercise();
    }
}
