package doa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import net.fitness.doa.ExerciseDoaImpl;
import net.fitness.model.Exercise;
import net.fitness.types.*;

import java.beans.Transient;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ExerciseDoaImplTest {

    private ExerciseDoaImpl edi;

    public ExerciseDoaImplTest() {
        try {
            edi = new ExerciseDoaImpl(
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/fitness_test", "postgres", "1234"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldAddExerciseAndReturnTrue(){
        edi.deleteAllExercise();
        assertTrue(edi.insertExercise(new Exercise(1,  Name.DEADLIFT.toString(), ExerciseType.UPPERBODY.toString(), 60, 48, LocalDate.now())));
    }
    
}
