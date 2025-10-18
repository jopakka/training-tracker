package fi.joonasniemi.trainingtracker.core.database.util

import androidx.room.TypeConverter
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetTypeEnum

internal class ExerciseSetTypeEnumConverter {
    @TypeConverter
    fun fromType(type: ExerciseSetTypeEnum): String? = type.name

    @TypeConverter
    fun toType(name: String): ExerciseSetTypeEnum = ExerciseSetTypeEnum.valueOf(name)
}