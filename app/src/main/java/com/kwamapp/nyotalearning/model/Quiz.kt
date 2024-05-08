package com.kwamapp.nyotalearning.model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kwamapp.nyotalearning.data.QuizQuestion

@Composable
fun Quiz(
    quizQuestion: QuizQuestion,
    onAnswerSelected: @Composable (Boolean) -> Unit // Callback to handle answer submission
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = quizQuestion.question, modifier = Modifier.padding(bottom = 16.dp))

        // Display quiz options as buttons
        quizQuestion.options.forEachIndexed { index, option ->
            Button(
                onClick = {
                    onAnswerSelected.toString()(index == quizQuestion.correctAnswerIndex)
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = option)
            }
        }
    }
}

private operator fun String.invoke(b: Boolean) {

}
