package com.kwamapp.nyotalearning.data

object ChemQuizDataSource {
    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "What is the chemical symbol for water?",
                options = listOf("H2O", "CO2", "NaCl"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which gas is essential for respiration?",
                options = listOf("Oxygen", "Carbon Dioxide", "Nitrogen"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the chemical formula for methane?",
                options = listOf("CH4", "H2O", "CO2"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which element has the symbol 'Fe'?",
                options = listOf("Iron", "Gold", "Silver"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the pH value of a neutral solution?",
                options = listOf("7", "10", "4"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which gas is produced during photosynthesis?",
                options = listOf("Oxygen", "Carbon Dioxide", "Hydrogen"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What type of reaction is photosynthesis?",
                options = listOf("Endothermic", "Exothermic", "Neutralization"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the process of converting a solid directly to a gas without passing through a liquid state?",
                options = listOf("Sublimation", "Condensation", "Evaporation"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which metal is liquid at room temperature?",
                options = listOf("Mercury", "Silver", "Gold"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the chemical formula for table salt?",
                options = listOf("NaCl", "HCl", "CaCl2"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the chemical formula for sulfuric acid?",
                options = listOf("H2SO4", "HCl", "NaOH"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which gas has a distinct smell of rotten eggs?",
                options = listOf("Hydrogen", "Sulfur Dioxide", "Nitrogen"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the main component of natural gas?",
                options = listOf("Methane", "Ethane", "Propane"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the hardest natural substance known?",
                options = listOf("Diamond", "Graphite", "Quartz"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which acid is found in vinegar?",
                options = listOf("Acetic Acid", "Hydrochloric Acid", "Sulfuric Acid"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the chemical symbol for gold?",
                options = listOf("Au", "Ag", "Fe"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the process of converting sugar into alcohol called?",
                options = listOf("Fermentation", "Distillation", "Oxidation"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which element is the most abundant in the Earth's atmosphere?",
                options = listOf("Nitrogen", "Oxygen", "Carbon"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the chemical formula for hydrogen peroxide?",
                options = listOf("H2O2", "H2SO4", "NaCl"),
                correctAnswerIndex = 0
            )
            // Add more quiz questions here...
        )
    }
}
