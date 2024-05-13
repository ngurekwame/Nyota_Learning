package com.kwamapp.nyotalearning.data

data class PhyNoteSection(val title: String, val content: String)

object PhyNotes {
    val sections = listOf(
        PhyNoteSection(
            title = "Mechanics",
            content = "This section covers laws of motion, forces, and energy."
        ),
        PhyNoteSection(
            title = "Electromagnetism",
            content = "Detailed information about electricity, magnetism, and electromagnetism."
        ),
        PhyNoteSection(
            title = "Optics",
            content = "Explanation of light, reflection, refraction, and lenses."
        )
        // Add more sections as needed
    )
}
