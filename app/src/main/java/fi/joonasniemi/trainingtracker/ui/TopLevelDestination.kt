package fi.joonasniemi.trainingtracker.ui

import androidx.annotation.StringRes
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @param:StringRes val titleTextId: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    EXERCISES(
        titleTextId = fi.joonasniemi.trainingtracker.assets.R.string.assets_exercises,
        route = ExercisesRoute ::class,
    ),
}