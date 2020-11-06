package net.fitness.doa;

import java.util.List;

import net.fitness.model.Exercise;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface ExerciseDoa {

	@SqlUpdate("insert into exercises(id, name, exercise_type, weight, reps, date_created) values(:id, :exerciseName, :exerciseType, :weight, :reps, :dateCreated)")
	boolean insertExercise(@BindBean Exercise exercise);

	@SqlQuery("select * from exercises where id=?")
	Exercise selectExercise(int id);


	@SqlQuery("select * from exercises")
	List<Exercise> selectAllExercises();

	@SqlUpdate("update exercises set name=:exerciseName, exercise_type=:exerciseType, weight=:weight, reps=:reps where id=:id")
	boolean updateExercise(@BindBean Exercise exercise);

	@SqlUpdate("delete from exercises where id=?")
	boolean deleteExercise(int id);

	@SqlUpdate("delete from exercises")
	boolean deleteAllExercise();
}
