package com.kwamapp.nyotalearning.data

data class HisNoteSection(val title: String, val content: String)

object HisNotes {
    val sections = listOf(
        HisNoteSection(
            title = "Ancient Civilizations",
            content = "This section covers early human societies and ancient civilizations."
        ),
        HisNoteSection(
            title = "World Wars",
            content = "Detailed information about World War I and World War II."
        ),
        HisNoteSection(
            title = "Modern History",
            content = "Explanation of recent historical events and developments."
        )
        // Add more sections as needed
    )
}
