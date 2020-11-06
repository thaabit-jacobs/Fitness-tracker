package net.fitness.model;

import java.time.LocalDate;

public class Exercise {
	
	private int id;
	private String name;
	private String exerciseType;
	private double weight;
	private int reps;
	private LocalDate date;
	
	public Exercise(int id, String name, String exerciseType, double weight, int reps, LocalDate date) {
		this.id = id;
		this.name = name;
		this.exerciseType = exerciseType;
		this.weight = weight;
		this.reps = reps;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
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

	public LocalDate getDate() {
		return date;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public void setDayOfWeek(LocalDate date) {
		this.date = date;
	}
}
