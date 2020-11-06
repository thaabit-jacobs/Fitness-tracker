package net.fitness.mappers;

import net.fitness.model.Exercise;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ExerciseMapper implements RowMapper<Exercise> {

    @Override
    public Exercise map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Exercise(rs.getInt("id"), rs.getString("name"), rs.getString("exercise_type"), rs.getDouble("weight"), rs.getInt("reps"), new Timestamp(rs.getDate("date_created").getTime()).toLocalDateTime().toLocalDate());
    }
}
