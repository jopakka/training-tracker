package fi.joonasniemi.trainingtracker.core.data.workouts.util

import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

internal object ExerciseTemplateSeeder {
    fun getInitialExerciseTemplates(): List<ExerciseTemplate> {
        return listOf(
            // Chest Exercises
            ExerciseTemplate(
                name = "Bench Press",
                category = "Chest",
                id = "bench_press",
            ),
            ExerciseTemplate(
                name = "Incline Dumbbell Press",
                category = "Chest",
                id = "incline_dumbbell_press",
            ),
            ExerciseTemplate(
                name = "Chest Flyes",
                category = "Chest",
                id = "bench_press",
            ),
            ExerciseTemplate(
                name = "Push-ups",
                category = "Chest",
                id = "push_ups",
            ),
            ExerciseTemplate(
                name = "Dips",
                category = "Chest",
                id = "dips",
            ),
            ExerciseTemplate(
                name = "Cable Crossover",
                category = "Chest",
                id = "cable_crossover",
            ),

            // Back Exercises
            ExerciseTemplate(
                name = "Deadlift",
                category = "Back",
                id = "deadlift",
            ),
            ExerciseTemplate(
                name = "Pull-ups",
                category = "Back",
                id = "pull_ups",
            ),
            ExerciseTemplate(
                name = "Bent-over Row",
                category = "Back",
                id = "bent_over_row",
            ),
            ExerciseTemplate(
                name = "Lat Pulldown",
                category = "Back",
                id = "lat_pulldown",
            ),
            ExerciseTemplate(
                name = "T-Bar Row",
                category = "Back",
                id = "t_bar_row",
            ),
            ExerciseTemplate(
                name = "Seated Cable Row",
                category = "Back",
                id = "seated_cable_row",
            ),
            ExerciseTemplate(
                name = "Face Pulls",
                category = "Back",
                id = "face_pulls",
            ),

            // Legs Exercises
            ExerciseTemplate(
                name = "Squats",
                category = "Legs",
                id = "squats",
            ),
            ExerciseTemplate(
                name = "Leg Press",
                category = "Legs",
                id = "leg_press",
            ),
            ExerciseTemplate(
                name = "Lunges",
                category = "Legs",
                id = "lunges",
            ),
            ExerciseTemplate(
                name = "Romanian Deadlift",
                category = "Legs",
                id = "romanian_deadlift",
            ),
            ExerciseTemplate(
                name = "Leg Curls",
                category = "Legs",
                id = "leg_curls",
            ),
            ExerciseTemplate(
                name = "Leg Extensions",
                category = "Legs",
                id = "leg_extensions",
            ),
            ExerciseTemplate(
                name = "Calf Raises",
                category = "Legs",
                id = "calf_raises",
            ),
            ExerciseTemplate(
                name = "Bulgarian Split Squats",
                category = "Legs",
                id = "bulgarian_split_squats",
            ),
            ExerciseTemplate(
                name = "Hip Thrusts",
                category = "Legs",
                id = "hip_thrusts",
            ),

            // Shoulders Exercises
            ExerciseTemplate(
                name = "Overhead Press",
                category = "Shoulders",
                id = "overhead_press",
            ),
            ExerciseTemplate(
                name = "Lateral Raises",
                category = "Shoulders",
                id = "lateral_raises",
            ),
            ExerciseTemplate(
                name = "Rear Delt Flyes",
                category = "Shoulders",
                id = "rear_delt_flyes",
            ),
            ExerciseTemplate(
                name = "Arnold Press",
                category = "Shoulders",
                id = "arnold_press",
            ),
            ExerciseTemplate(
                name = "Upright Rows",
                category = "Shoulders",
                id = "upright_rows",
            ),
            ExerciseTemplate(
                name = "Shrugs",
                category = "Shoulders",
                id = "shrugs",
            ),

            // Arms Exercises
            ExerciseTemplate(
                name = "Barbell Curls",
                category = "Arms",
                id = "barbell_curls",
            ),
            ExerciseTemplate(
                name = "Hammer Curls",
                category = "Arms",
                id = "hammer_curls",
            ),
            ExerciseTemplate(
                name = "Tricep Dips",
                category = "Arms",
                id = "tricep_dips",
            ),
            ExerciseTemplate(
                name = "Close-grip Bench Press",
                category = "Arms",
                id = "close_grip_bench_press",
            ),
            ExerciseTemplate(
                name = "Tricep Pushdowns",
                category = "Arms",
                id = "tricep_pushdowns",
            ),
            ExerciseTemplate(
                name = "Preacher Curls",
                category = "Arms",
                id = "preacher_curls",
            ),
            ExerciseTemplate(
                name = "21s Bicep Curls",
                category = "Arms",
                id = "21s_bicep_curls",
            ),
            ExerciseTemplate(
                name = "Overhead Tricep Extension",
                category = "Arms",
                id = "overhead_tricep_extension",
            ),

            // Core Exercises
            ExerciseTemplate(
                name = "Planks",
                category = "Core",
                id = "planks",
            ),
            ExerciseTemplate(
                name = "Crunches",
                category = "Core",
                id = "crunches",
            ),
            ExerciseTemplate(
                name = "Russian Twists",
                category = "Core",
                id = "russian_twists",
            ),
            ExerciseTemplate(
                name = "Mountain Climbers",
                category = "Core",
                id = "mountain_climbers",
            ),
            ExerciseTemplate(
                name = "Dead Bug",
                category = "Core",
                id = "dead_bug",
            ),
            ExerciseTemplate(
                name = "Hanging Leg Raises",
                category = "Core",
                id = "hanging_leg_raises",
            ),
            ExerciseTemplate(
                name = "Bicycle Crunches",
                category = "Core",
                id = "bicycle_crunches",
            ),
            ExerciseTemplate(
                name = "Ab Wheel Rollouts",
                category = "Core",
                id = "ab_wheel_rollouts",
            ),

            // Cardio Exercises
            ExerciseTemplate(
                name = "Treadmill Running",
                category = "Cardio",
                id = "treadmill_running",
            ),
            ExerciseTemplate(
                name = "Cycling",
                category = "Cardio",
                id = "cycling",
            ),
            ExerciseTemplate(
                name = "Rowing Machine",
                category = "Cardio",
                id = "rowing_machine",
            ),
            ExerciseTemplate(
                name = "Elliptical",
                category = "Cardio",
                id = "elliptical",
            ),
            ExerciseTemplate(
                name = "Burpees",
                category = "Cardio",
                id = "burpees",
            ),
            ExerciseTemplate(
                name = "Jump Rope",
                category = "Cardio",
                id = "jump_rope",
            ),
            ExerciseTemplate(
                name = "Stair Climbing",
                category = "Cardio",
                id = "stair_climbing",
            ),
            ExerciseTemplate(
                name = "Battle Ropes",
                category = "Cardio",
                id = "battle_ropes",
            )
        )
    }
}