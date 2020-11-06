package doa;

import net.fitness.doa.ExerciseDoaImpl;
import net.fitness.model.Exercise;
import net.fitness.types.*;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExerciseDoaImplTest {

    private ExerciseDoaImpl edi;
    private Exercise exercise;

    public ExerciseDoaImplTest() {
        edi = new ExerciseDoaImpl(Jdbi.create("jdbc:postgresql://localhost:5432/fitness_test", "thaabit", "1234"));
    }

    @Test
    void shouldAddExerciseAndReturnTrue(){
        edi.deleteAllExercise();
        assertTrue(edi.insertExercise(new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now())));
    }

    @Test
    void shouldReturnExcercise(){
        edi.deleteAllExercise();
        edi.insertExercise(new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now()));
        assertEquals(1, edi.selectExercise(1).getId());
    }

    @Test
    void shouldReturnAllExcercise(){
        edi.deleteAllExercise();
        edi.insertExercise(new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now()));
        assertEquals(1, edi.selectAllExercises().size());
    }

    @Test
    void shouldUpdateExercise(){
        Exercise ex = new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now());
        edi.deleteAllExercise();
        edi.insertExercise(ex);
        ex.setExerciseType(ExerciseType.LOWERBODY.toString());
        edi.updateExercise(ex);
        assertEquals(ExerciseType.LOWERBODY.toString(), edi.selectExercise(1).getExerciseType());
    }

    @Test
    void shouldDeleteExercises(){
        Exercise ex = new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now());
        edi.deleteAllExercise();
        edi.insertExercise(ex);
        edi.deleteExercise(1);
        assertEquals(0, edi.selectAllExercises().size());
    }
}
