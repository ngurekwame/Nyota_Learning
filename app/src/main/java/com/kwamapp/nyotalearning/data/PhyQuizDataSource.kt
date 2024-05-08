package com.kwamapp.nyotalearning.data

object PhyQuizDataSource {
    // Define a function to load physics quiz questions
    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "What is the SI unit of force?",
                options = listOf("Watt", "Joule", "Newton"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which law states that an object will remain at rest or in uniform motion unless acted upon by an external force?",
                options = listOf("Newton's First Law of Motion", "Newton's Second Law of Motion", "Newton's Third Law of Motion"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the acceleration due to gravity on Earth?",
                options = listOf("9.8 m/s²", "10 m/s²", "8.2 m/s²"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the formula for calculating work done?",
                options = listOf("Force × Velocity", "Mass × Acceleration", "Force × Distance"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which type of energy is associated with motion?",
                options = listOf("Potential Energy", "Kinetic Energy", "Mechanical Energy"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which scientist formulated the laws of motion?",
                options = listOf("Albert Einstein", "Isaac Newton", "Galileo Galilei"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the formula to calculate momentum?",
                options = listOf("Mass × Velocity", "Force × Time", "Mass × Acceleration"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the unit of electrical resistance?",
                options = listOf("Ampere", "Volt", "Ohm"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which law states that the total electric charge in a closed system is constant?",
                options = listOf("Ohm's Law", "Gauss's Law", "Conservation of Charge"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the phenomenon of bending of light as it passes from one medium to another?",
                options = listOf("Refraction", "Reflection", "Dispersion"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which color has the longest wavelength?",
                options = listOf("Red", "Green", "Blue"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the unit of electric charge?",
                options = listOf("Volt", "Ampere", "Coulomb"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which type of lens can correct nearsightedness?",
                options = listOf("Convex Lens", "Concave Lens", "Bifocal Lens"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the law that states that every action has an equal and opposite reaction?",
                options = listOf("Newton's First Law of Motion", "Newton's Second Law of Motion", "Newton's Third Law of Motion"),
                correctAnswerIndex = 2
            )
            // Add more physics quiz questions here...
        )
    }
}
