package com.kwamapp.nyotalearning.data

object BioQuizDataSource {

    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "What is the basic unit of life?",
                options = listOf("Organ", "System", "Cell"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which gas is essential for respiration?",
                options = listOf("Oxygen", "Carbon Dioxide", "Nitrogen"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which organelle is known as the 'powerhouse' of the cell?",
                options = listOf("Nucleus", "Mitochondrion", "Endoplasmic Reticulum"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which process produces energy in the form of ATP within mitochondria?",
                options = listOf("Photosynthesis", "Glycolysis", "Cellular Respiration"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which human body system is responsible for protecting the body against pathogens?",
                options = listOf("Digestive System", "Respiratory System", "Immune System"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which type of tissue connects bones to other bones in the body?",
                options = listOf("Muscle Tissue", "Nervous Tissue", "Connective Tissue"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the process by which plants make their food using sunlight?",
                options = listOf("Respiration", "Transpiration", "Photosynthesis"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which blood vessels carry oxygen-rich blood away from the heart?",
                options = listOf("Veins", "Capillaries", "Arteries"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which hormone is responsible for regulating blood sugar levels?",
                options = listOf("Estrogen", "Insulin", "Testosterone"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which structure in plants is responsible for absorbing water and minerals?",
                options = listOf("Stem", "Roots", "Leaves"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which process allows plants to release excess water vapor through small openings in leaves?",
                options = listOf("Photosynthesis", "Transpiration", "Respiration"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the smallest unit of heredity?",
                options = listOf("Chromosome", "Gene", "Allele"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which structure in the human respiratory system prevents food from entering the trachea?",
                options = listOf("Larynx", "Epiglottis", "Bronchi"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the process of breaking down food into simpler substances that can be absorbed by the body?",
                options = listOf("Excretion", "Digestion", "Circulation"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which type of cell division results in the formation of gametes?",
                options = listOf("Mitosis", "Meiosis", "Binary Fission"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which organ in the human body produces insulin?",
                options = listOf("Pancreas", "Liver", "Kidneys"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is the main function of red blood cells?",
                options = listOf("Transport Oxygen", "Fight Infections", "Produce Hormones"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which structure in plants is responsible for gas exchange?",
                options = listOf("Xylem", "Phloem", "Stomata"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the name of the process by which plants bend towards sunlight?",
                options = listOf("Phototropism", "Hydrotropism", "Geotropism"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which part of a flower contains the pollen grains?",
                options = listOf("Pistil", "Stamen", "Sepal"),
                correctAnswerIndex = 1
            )
            // Add more quiz questions here...
        )
    }
}
