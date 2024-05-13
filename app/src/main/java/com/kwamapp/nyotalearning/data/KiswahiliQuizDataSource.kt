package com.kwamapp.nyotalearning.data

object KiswahiliQuizDataSource {

    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "Neno 'rafiki' ni aina gani ya nomino?",
                options = listOf("com.kwamapp.nyotalearning.ui.theme.screens.subjects.Kiswahili sanifu", "com.kwamapp.nyotalearning.ui.theme.screens.subjects.Kiswahili cha asili", "com.kwamapp.nyotalearning.ui.theme.screens.subjects.Kiswahili fasaha"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Taja tahajia sahihi ya neno 'shule'.",
                options = listOf("Shule", "Shulee", "Shulhe"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Ni sentensi ipi inayoonyesha jamii ya kiswahili 'kisichokuwa na maana'?",
                options = listOf("Kitenzi hakitokei tena", "Neno halina maana", "Neno lina maana tofauti na kawaida"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Taja aina za maneno kwa mujibu wa muundo.",
                options = listOf("Vitenzi, vinyume na vinyume", "Vinyume, vya kawaida, pekee na vya wingi", "Vinyume, vya kawaida, pekee na vitenzi"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Neno lipi ni bora kati ya 'kizuri' na 'nzuri'?",
                options = listOf("'Kizuri'", "'Nzuri'", "Vyote vinafaa"),
                correctAnswerIndex = 1
            )
            // Add more com.kwamapp.nyotalearning.ui.theme.screens.subjects.Kiswahili quiz questions here...
        )
    }
}
