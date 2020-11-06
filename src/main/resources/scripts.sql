create table exercises(
    id serial primary key not null,
    name varchar(225) not null,
    exercise_type varchar(225) not null,
    weight decimal(5, 2) not null,
    reps int not null,
    DayOfWeek varchar(225) not null
);