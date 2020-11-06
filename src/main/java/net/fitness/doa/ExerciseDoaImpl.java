package net.fitness.doa;

import java.util.List;

import net.fitness.mappers.ExerciseMapper;
import net.fitness.model.Exercise;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ExerciseDoaImpl implements ExerciseDoa{

	private Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/fitness", "thaabit", "1234");

	public ExerciseDoaImpl() {
		jdbi.installPlugin((JdbiPlugin) new SqlObjectPlugin());
	}

	public ExerciseDoaImpl(Jdbi jdbi) {
		this.jdbi = jdbi;
		jdbi.installPlugin((JdbiPlugin) new SqlObjectPlugin());
	}

	@Override
	public boolean insertExercise(Exercise exercise) {
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.insertExercise(exercise));
	}


	@Override
	public Exercise selectExercise(int id) {
		jdbi.registerRowMapper(new ExerciseMapper());
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.selectExercise(id));
	}

	@Override
	public List<Exercise> selectAllExercises() {
		jdbi.registerRowMapper(new ExerciseMapper());
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.selectAllExercises());
	}

	@Override
	public boolean updateExercise(Exercise exercise) {
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.updateExercise(exercise));
	}

	@Override
	public boolean deleteExercise(int id) {
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.deleteExercise(id));
	}

	@Override
	public boolean deleteAllExercise() {
		return jdbi.withExtension(ExerciseDoa.class, doa -> doa.deleteAllExercise());
	}

}
