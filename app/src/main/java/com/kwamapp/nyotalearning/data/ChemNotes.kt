package com.kwamapp.nyotalearning.data

data class NoteSection(val title: String, val content: String)

object ChemNotes {
    val sections = listOf(
        NoteSection(
            title = "Introduction",
            content = "This section covers the basics of chemistry."
        ),
        NoteSection(
            title = "Atoms and Molecules",
            content = "Detailed information about atoms and molecules."
        ),
        NoteSection(
            title = "Chemical Reactions",
            content = "Explanation of various types of chemical reactions."
        )
        //Lorem
    )
}