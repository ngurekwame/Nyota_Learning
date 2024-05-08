package com.kwamapp.nyotalearning.data

object EnglishQuizDataSource {
    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "What is a noun?",
                options = listOf("a naming word", "an action word", "describes an action"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is a verb?",
                options = listOf("a naming word", "an action word", "describes an action"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which word is a conjunction?",
                options = listOf("run", "and", "blue"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the past tense of 'eat'?",
                options = listOf("eaten", "ate", "eating"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Choose the correct plural form of 'book':",
                options = listOf("bookes", "books", "boox"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which sentence is correct?",
                options = listOf("He go to school.", "She go to school.", "They go to school."),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the opposite of 'hot'?",
                options = listOf("cold", "warm", "freezing"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Which word is an adverb?",
                options = listOf("fast", "jump", "apple"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What does 'homonym' mean?",
                options = listOf("a word that sounds the same as another word", "a big word", "a red word"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is a synonym for 'happy'?",
                options = listOf("sad", "angry", "joyful"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Which word is a preposition?",
                options = listOf("jump", "under", "green"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What does 'antonym' mean?",
                options = listOf("a word that means the same as another word", "a word that means opposite", "a short word"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the present participle of 'swim'?",
                options = listOf("swimming", "swimmed", "swam"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What is a collective noun for a group of lions?",
                options = listOf("herd", "pride", "flock"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Choose the correct possessive form:",
                options = listOf("its", "it's", "its'"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "What does 'subject' mean in grammar?",
                options = listOf("a word that describes a noun", "the main part of a sentence", "an adjective"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which sentence is correct?",
                options = listOf("The cat is sit on the mat.", "The cat are sit on the mat.", "The cat is sitting on the mat."),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is a compound word?",
                options = listOf("a word made of two vowels", "a word made of two consonants", "a word made of two or more smaller words"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is an interjection?",
                options = listOf("a word that joins two sentences", "a word that expresses emotion or exclamation", "a type of verb"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Which word is a pronoun?",
                options = listOf("run", "he", "happy"),
                correctAnswerIndex = 1
            )
            // Add more quiz questions here...
        )
    }
}

