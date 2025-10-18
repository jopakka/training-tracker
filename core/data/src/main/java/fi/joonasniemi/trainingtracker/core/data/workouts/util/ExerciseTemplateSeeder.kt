package fi.joonasniemi.trainingtracker.core.data.workouts.util

import fi.joonasniemi.trainingtracker.core.model.ExerciseSetType
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetTypeEnum
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

internal object ExerciseTemplateSeeder {
    fun getInitialExerciseTemplates(): List<ExerciseTemplate> {
        return listOf(
            // Chest Exercises
            ExerciseTemplate(
                name = "Bench Press",
                category = "chest",
                id = "bench_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Incline Dumbbell Press",
                category = "chest",
                id = "incline_dumbbell_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Chest Flyes",
                category = "chest",
                id = "bench_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Push-ups",
                category = "chest",
                id = "push_ups",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Dips",
                category = "chest",
                id = "dips",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Cable Crossover",
                category = "chest",
                id = "cable_crossover",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),

            // Back Exercises
            ExerciseTemplate(
                name = "Deadlift",
                category = "back",
                id = "deadlift",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Pull-ups",
                category = "back",
                id = "pull_ups",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Bent-over Row",
                category = "back",
                id = "bent_over_row",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Lat Pulldown",
                category = "back",
                id = "lat_pulldown",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "T-Bar Row",
                category = "back",
                id = "t_bar_row",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Seated Cable Row",
                category = "back",
                id = "seated_cable_row",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Face Pulls",
                category = "back",
                id = "face_pulls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),

            // Legs Exercises
            ExerciseTemplate(
                name = "Squats",
                category = "legs",
                id = "squats",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Leg Press",
                category = "legs",
                id = "leg_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Lunges",
                category = "legs",
                id = "lunges",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Romanian Deadlift",
                category = "legs",
                id = "romanian_deadlift",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Leg Curls",
                category = "legs",
                id = "leg_curls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Leg Extensions",
                category = "legs",
                id = "leg_extensions",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Calf Raises",
                category = "legs",
                id = "calf_raises",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Bulgarian Split Squats",
                category = "legs",
                id = "bulgarian_split_squats",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Hip Thrusts",
                category = "legs",
                id = "hip_thrusts",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),

            // Shoulders Exercises
            ExerciseTemplate(
                name = "Overhead Press",
                category = "shoulders",
                id = "overhead_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Lateral Raises",
                category = "shoulders",
                id = "lateral_raises",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Rear Delt Flyes",
                category = "shoulders",
                id = "rear_delt_flyes",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Arnold Press",
                category = "shoulders",
                id = "arnold_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Upright Rows",
                category = "shoulders",
                id = "upright_rows",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Shrugs",
                category = "shoulders",
                id = "shrugs",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),

            // Arms Exercises
            ExerciseTemplate(
                name = "Barbell Curls",
                category = "arms",
                id = "barbell_curls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Hammer Curls",
                category = "arms",
                id = "hammer_curls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Tricep Dips",
                category = "arms",
                id = "tricep_dips",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Close-grip Bench Press",
                category = "arms",
                id = "close_grip_bench_press",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Tricep Pushdowns",
                category = "arms",
                id = "tricep_pushdowns",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Preacher Curls",
                category = "arms",
                id = "preacher_curls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "21s Bicep Curls",
                category = "arms",
                id = "21s_bicep_curls",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Overhead Tricep Extension",
                category = "arms",
                id = "overhead_tricep_extension",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),

            // Core Exercises
            ExerciseTemplate(
                name = "Planks",
                category = "core",
                id = "planks",
                type = ExerciseSetTypeEnum.TIME_AND_WEIGHT,
            ),
            ExerciseTemplate(
                name = "Crunches",
                category = "core",
                id = "crunches",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Russian Twists",
                category = "core",
                id = "russian_twists",
                type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
            ),
            ExerciseTemplate(
                name = "Mountain Climbers",
                category = "core",
                id = "mountain_climbers",
                type = ExerciseSetTypeEnum.REPS,
            ),
            ExerciseTemplate(
                name = "Dead Bug",
                category = "core",
                id = "dead_bug",
                type = ExerciseSetTypeEnum.REPS,
            ),
            ExerciseTemplate(
                name = "Hanging Leg Raises",
                category = "core",
                id = "hanging_leg_raises",
                type = ExerciseSetTypeEnum.REPS,
            ),
            ExerciseTemplate(
                name = "Bicycle Crunches",
                category = "core",
                id = "bicycle_crunches",
                type = ExerciseSetTypeEnum.REPS,
            ),
            ExerciseTemplate(
                name = "Ab Wheel Rollouts",
                category = "core",
                id = "ab_wheel_rollouts",
                type = ExerciseSetTypeEnum.REPS,
            ),

            // Cardio Exercises
            ExerciseTemplate(
                name = "Treadmill Running",
                category = "cardio",
                id = "treadmill_running",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Cycling",
                category = "cardio",
                id = "cycling",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Rowing Machine",
                category = "cardio",
                id = "rowing_machine",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Elliptical",
                category = "cardio",
                id = "elliptical",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Burpees",
                category = "cardio",
                id = "burpees",
                type = ExerciseSetTypeEnum.REPS,
            ),
            ExerciseTemplate(
                name = "Jump Rope",
                category = "cardio",
                id = "jump_rope",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Stair Climbing",
                category = "cardio",
                id = "stair_climbing",
                type = ExerciseSetTypeEnum.TIME,
            ),
            ExerciseTemplate(
                name = "Battle Ropes",
                category = "cardio",
                id = "battle_ropes",
                type = ExerciseSetTypeEnum.TIME,
            )
        )
    }
}