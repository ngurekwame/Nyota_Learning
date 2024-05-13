package com.kwamapp.nyotalearning.data

data class EngNoteSection(val title: String, val content: String)

object EngNotes {
    val sections = listOf(
        EngNoteSection(
            title = "Grammar and Syntax",
            content = "This section covers English grammar rules and sentence structure."
        ),
        EngNoteSection(
            title = "Literature",
            content = "Detailed analysis of classic and contemporary literature."
        ),
        EngNoteSection(
            title = "Writing Skills",
            content = "Explanation of effective writing techniques and composition."
        )
        // Add more sections as needed
    )
}
