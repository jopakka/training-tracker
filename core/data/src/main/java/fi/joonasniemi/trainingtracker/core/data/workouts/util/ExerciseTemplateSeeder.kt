package fi.joonasniemi.trainingtracker.core.data.workouts.util

import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

internal object ExerciseTemplateSeeder {
    fun getInitialExerciseTemplates(): List<ExerciseTemplate> {
        return listOf(
            // Chest Exercises
            ExerciseTemplate(
                name = "Bench Press",
                category = "chest",
                id = "bench_press",
            ),
            ExerciseTemplate(
                name = "Incline Dumbbell Press",
                category = "chest",
                id = "incline_dumbbell_press",
            ),
            ExerciseTemplate(
                name = "Chest Flyes",
                category = "chest",
                id = "bench_press",
            ),
            ExerciseTemplate(
                name = "Push-ups",
                category = "chest",
                id = "push_ups",
            ),
            ExerciseTemplate(
                name = "Dips",
                category = "chest",
                id = "dips",
            ),
            ExerciseTemplate(
                name = "Cable Crossover",
                category = "chest",
                id = "cable_crossover",
            ),

            // Back Exercises
            ExerciseTemplate(
                name = "Deadlift",
                category = "back",
                id = "deadlift",
            ),
            ExerciseTemplate(
                name = "Pull-ups",
                category = "back",
                id = "pull_ups",
            ),
            ExerciseTemplate(
                name = "Bent-over Row",
                category = "back",
                id = "bent_over_row",
            ),
            ExerciseTemplate(
                name = "Lat Pulldown",
                category = "back",
                id = "lat_pulldown",
            ),
            ExerciseTemplate(
                name = "T-Bar Row",
                category = "back",
                id = "t_bar_row",
            ),
            ExerciseTemplate(
                name = "Seated Cable Row",
                category = "back",
                id = "seated_cable_row",
            ),
            ExerciseTemplate(
                name = "Face Pulls",
                category = "back",
                id = "face_pulls",
            ),

            // Legs Exercises
            ExerciseTemplate(
                name = "Squats",
                category = "legs",
                id = "squats",
            ),
            ExerciseTemplate(
                name = "Leg Press",
                category = "legs",
                id = "leg_press",
            ),
            ExerciseTemplate(
                name = "Lunges",
                category = "legs",
                id = "lunges",
            ),
            ExerciseTemplate(
                name = "Romanian Deadlift",
                category = "legs",
                id = "romanian_deadlift",
            ),
            ExerciseTemplate(
                name = "Leg Curls",
                category = "legs",
                id = "leg_curls",
            ),
            ExerciseTemplate(
                name = "Leg Extensions",
                category = "legs",
                id = "leg_extensions",
            ),
            ExerciseTemplate(
                name = "Calf Raises",
                category = "legs",
                id = "calf_raises",
            ),
            ExerciseTemplate(
                name = "Bulgarian Split Squats",
                category = "legs",
                id = "bulgarian_split_squats",
            ),
            ExerciseTemplate(
                name = "Hip Thrusts",
                category = "legs",
                id = "hip_thrusts",
            ),

            // Shoulders Exercises
            ExerciseTemplate(
                name = "Overhead Press",
                category = "shoulders",
                id = "overhead_press",
            ),
            ExerciseTemplate(
                name = "Lateral Raises",
                category = "shoulders",
                id = "lateral_raises",
            ),
            ExerciseTemplate(
                name = "Rear Delt Flyes",
                category = "shoulders",
                id = "rear_delt_flyes",
            ),
            ExerciseTemplate(
                name = "Arnold Press",
                category = "shoulders",
                id = "arnold_press",
            ),
            ExerciseTemplate(
                name = "Upright Rows",
                category = "shoulders",
                id = "upright_rows",
            ),
            ExerciseTemplate(
                name = "Shrugs",
                category = "shoulders",
                id = "shrugs",
            ),

            // Arms Exercises
            ExerciseTemplate(
                name = "Barbell Curls",
                category = "arms",
                id = "barbell_curls",
            ),
            ExerciseTemplate(
                name = "Hammer Curls",
                category = "arms",
                id = "hammer_curls",
            ),
            ExerciseTemplate(
                name = "Tricep Dips",
                category = "arms",
                id = "tricep_dips",
            ),
            ExerciseTemplate(
                name = "Close-grip Bench Press",
                category = "arms",
                id = "close_grip_bench_press",
            ),
            ExerciseTemplate(
                name = "Tricep Pushdowns",
                category = "arms",
                id = "tricep_pushdowns",
            ),
            ExerciseTemplate(
                name = "Preacher Curls",
                category = "arms",
                id = "preacher_curls",
            ),
            ExerciseTemplate(
                name = "21s Bicep Curls",
                category = "arms",
                id = "21s_bicep_curls",
            ),
            ExerciseTemplate(
                name = "Overhead Tricep Extension",
                category = "arms",
                id = "overhead_tricep_extension",
            ),

            // Core Exercises
            ExerciseTemplate(
                name = "Planks",
                category = "core",
                id = "planks",
            ),
            ExerciseTemplate(
                name = "Crunches",
                category = "core",
                id = "crunches",
            ),
            ExerciseTemplate(
                name = "Russian Twists",
                category = "core",
                id = "russian_twists",
            ),
            ExerciseTemplate(
                name = "Mountain Climbers",
                category = "core",
                id = "mountain_climbers",
            ),
            ExerciseTemplate(
                name = "Dead Bug",
                category = "core",
                id = "dead_bug",
            ),
            ExerciseTemplate(
                name = "Hanging Leg Raises",
                category = "core",
                id = "hanging_leg_raises",
            ),
            ExerciseTemplate(
                name = "Bicycle Crunches",
                category = "core",
                id = "bicycle_crunches",
            ),
            ExerciseTemplate(
                name = "Ab Wheel Rollouts",
                category = "core",
                id = "ab_wheel_rollouts",
            ),

            // Cardio Exercises
            ExerciseTemplate(
                name = "Treadmill Running",
                category = "cardio",
                id = "treadmill_running",
            ),
            ExerciseTemplate(
                name = "Cycling",
                category = "cardio",
                id = "cycling",
            ),
            ExerciseTemplate(
                name = "Rowing Machine",
                category = "cardio",
                id = "rowing_machine",
            ),
            ExerciseTemplate(
                name = "Elliptical",
                category = "cardio",
                id = "elliptical",
            ),
            ExerciseTemplate(
                name = "Burpees",
                category = "cardio",
                id = "burpees",
            ),
            ExerciseTemplate(
                name = "Jump Rope",
                category = "cardio",
                id = "jump_rope",
            ),
            ExerciseTemplate(
                name = "Stair Climbing",
                category = "cardio",
                id = "stair_climbing",
            ),
            ExerciseTemplate(
                name = "Battle Ropes",
                category = "cardio",
                id = "battle_ropes",
            )
        )
    }
}