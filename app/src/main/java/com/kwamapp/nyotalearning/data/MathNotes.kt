package com.kwamapp.nyotalearning.data

data class MathNoteSection(val title: String, val content: String)

object MathNotes {
    val sections = listOf(
        MathNoteSection(
            title = "Algebra",
            content = "Algebra is a branch of mathematics that deals with symbols and the rules for manipulating these symbols. It involves solving equations, manipulating expressions, and understanding patterns and relationships."
        ),
        MathNoteSection(
            title = "Geometry",
            content = "Geometry is the study of shapes, sizes, positions, and dimensions of things. It includes concepts like points, lines, angles, surfaces, and solids. Geometry explores properties of objects in space and relationships between them."
        ),
        MathNoteSection(
            title = "Calculus",
            content = "Calculus is a branch of mathematics that deals with continuous change. It includes concepts such as derivatives, integrals, limits, and infinite series. Calculus is essential in understanding rates of change and accumulation."
        ),
        MathNoteSection(
            title = "Statistics",
            content = "Statistics is the study of data collection, organization, analysis, interpretation, and presentation. It involves methods for drawing conclusions from data, making predictions, and understanding uncertainty."
        ),
        MathNoteSection(
            title = "Probability",
            content = "Probability is the measure of the likelihood that an event will occur. It involves analyzing random phenomena and quantifying uncertainty. Probability theory is used extensively in various fields including statistics, finance, and science."
        )
        // Add more sections as needed
    )
}
