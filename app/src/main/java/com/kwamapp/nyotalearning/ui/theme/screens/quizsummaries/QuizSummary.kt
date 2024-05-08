package com.kwamapp.nyotalearning.ui.theme.screens.quizsummaries

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizSummary(
    navController: NavController,
    quizResults: List<Boolean>
) {
    val totalQuestions = quizResults.size
    val correctCount = quizResults.count { it }
    val incorrectCount = totalQuestions - correctCount

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Quiz Summary",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = "Total Questions: $totalQuestions",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Correct Answers: $correctCount",
                color = Color.Green,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Incorrect Answers: $incorrectCount",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Back to Quiz")
            }
        }
    }
}

@Preview
@Composable
private fun PreviewQuizSummary() {
    QuizSummary(
        navController = rememberNavController(),
        quizResults = listOf(true, false, true, true) // Example quiz results (true = correct, false = incorrect)
    )
}
