package net.fitness.doa;

import java.util.List;

import net.fitness.model.Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ExerciseDoaImpl implements ExerciseDoa{ 
	
	private Connection conn;

	private Statement stmt;
	private PreparedStatement pstmt;

	private final String insertExercise = "insert into exercises (name, exercise_type, weight, reps, DayOfWeek) values (?, ?, ?, ?, ?)";
	private final String deleteAllExercises = "delete from exercises";

	public ExerciseDoaImpl() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fitness", "postgres", "1234");
		} catch (SQLException sqle) {
			System.out.println("Could get database connection");
			sqle.printStackTrace();
		}catch(ClassNotFoundException cne) {
			System.out.println("Could not load drivers");
			cne.printStackTrace();
		}
	}

	public ExerciseDoaImpl(Connection conn) {
		try {
			Class.forName("org.postgresql.Driver");
			this.conn = conn;
		} catch(ClassNotFoundException cne) {
			System.out.println("Could not load drivers");
			cne.printStackTrace();
		}
	}

	public boolean insertExercise(Exercise exercise) {
		try{
			pstmt = conn.prepareStatement(insertExercise);
			pstmt.setString(1, exercise.getName());
			pstmt.setString(2, exercise.getExerciseType());
			pstmt.setDouble(3, exercise.getWeight());
			pstmt.setInt(4, exercise.getReps());
			pstmt.setString(5, exercise.getDayOfWeek());

			pstmt.executeUpdate();

			pstmt.close();

			return true;
		}catch (SQLException sqle) {
			System.out.println("Could not insert exercise");
			sqle.printStackTrace();
		}

		return false;
	}

	public Exercise selectExercise(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Exercise> selectAllExercises() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteExercise(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAllExercise() {
		try{
			stmt = conn.createStatement();

			stmt.executeUpdate(deleteAllExercises);

			stmt.close();

			return true;
		}catch (SQLException sqle) {
			System.out.println("Could not insert exercise");
			sqle.printStackTrace();
		}

		return false;
	}

}
