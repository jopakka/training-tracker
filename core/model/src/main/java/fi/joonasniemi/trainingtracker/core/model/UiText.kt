package fi.joonasniemi.trainingtracker.core.model

import android.content.Context

sealed class UiText {
    data class Plain(val text: String) : UiText()
    data class Resource(val resId: Int) : UiText()
}

fun UiText.asString(context: Context): String = when (this) {
    is UiText.Plain -> text
    is UiText.Resource -> context.getString(resId)
}