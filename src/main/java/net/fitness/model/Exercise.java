package net.fitness.model;

import java.time.LocalDate;

public class Exercise {
	
	private int id;
	private String exerciseName;
	private String exerciseType;
	private double weight;
	private int reps;
	private LocalDate dateCreated;
	
	public Exercise(int id, String exerciseName, String exerciseType, double weight, int reps, LocalDate dateCreated) {
		this.id = id;
		this.exerciseName = exerciseName;
		this.exerciseType = exerciseType;
		this.weight = weight;
		this.reps = reps;
		this.dateCreated = dateCreated;
	}
	
	public int getId() {
		return id;
	}
	
	public String getExerciseName() {
		return exerciseName;
	}
	
	public String getExerciseType() {
		return exerciseType;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getReps() {
		return reps;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}

	public void setDateCreated(LocalDate date) {
		this.dateCreated = dateCreated;
	}
}
