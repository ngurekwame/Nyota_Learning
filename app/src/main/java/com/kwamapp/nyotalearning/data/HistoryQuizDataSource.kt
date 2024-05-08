package com.kwamapp.nyotalearning.data

object HistoryQuizDataSource {

    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "In which country was the ancient city of Alexandria located?",
                options = listOf("Egypt", "Greece", "Rome"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Who was the famous emperor of the Byzantine Empire who moved the capital to Constantinople?",
                options = listOf("Augustus", "Nero", "Constantine"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which nations were part of World War I?",
                options = listOf("Britain, Germany, Russia", "Germany, Italy, Russia", "Britain, France, Russia"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What event occurred on July 20, 1969?",
                options = listOf("French Revolution", "World War I", "Moon Landing by Humans"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What was the powerful capital of the Ottoman Empire in the 15th and 16th centuries?",
                options = listOf("Mecca", "Constantinople", "Venice"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "How many branches of government ensure the balance of powers?",
                options = listOf("One branch", "Two branches", "Three branches"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the responsibility of the Parliament of Kenya?",
                options = listOf("Conducting elections", "Creating laws, overseeing the government", "Overseeing the judiciary"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which government body is responsible for dispensing justice to citizens?",
                options = listOf("Military", "Cabinet", "Judiciary"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Who is the head of government in a parliamentary system?",
                options = listOf("President", "Prime Minister", "Speaker"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which government body is responsible for administrative and executive activities?",
                options = listOf("Cabinet", "Parliament", "National Security Agency"),
                correctAnswerIndex = 0
            )
            // Add more History and Government quiz questions here...
        )
    }
}
