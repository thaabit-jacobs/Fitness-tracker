package net.fitness.doa;

import java.util.List;

import net.fitness.model.Exercise;

public interface ExerciseDoa {
	
	boolean insertExercise(Exercise exercise);
	
	Exercise selectExercise(int id);
	
	List<Exercise> selectAllExercises();
	
	boolean updateExercise(Exercise exercise);
	
	boolean deleteExercise(int id);
}
