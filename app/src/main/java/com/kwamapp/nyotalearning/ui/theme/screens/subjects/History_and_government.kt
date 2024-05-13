import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.data.HisNotes
import com.kwamapp.nyotalearning.data.HistoryQuizDataSource
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun History(navController: NavController) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    val quizQuestions = remember { HistoryQuizDataSource.loadQuizQuestions() }
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var subjectName= "History"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = subjectName.uppercase(),
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                Text(
                    text = "$subjectName Notes".uppercase(),
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                HisNotes.sections.forEach { section ->
                    ListItem(name = section.title, content = section.content)
                }
            }

            item {
                Spacer(modifier = Modifier.padding(30.dp))
            }

            item {
                if (currentQuestionIndex < quizQuestions.size) {
                    val currentQuestion = quizQuestions[currentQuestionIndex]

                    // Display quiz question and options
                    Column(
                        modifier = Modifier.padding(vertical = 16.dp)
                    ) {
                        Text(text = currentQuestion.question)

                        currentQuestion.options.forEach { option ->
                            Button(
                                onClick = {
                                    selectedOption = option
                                    showResult = true

                                    // Check if the selected option is correct after delay
                                    GlobalScope.launch {
                                        delay(1000)
                                        val isCorrect =
                                            option == currentQuestion.options[currentQuestion.correctAnswerIndex]
                                        if (isCorrect) {
                                            currentQuestionIndex++
                                        }
                                        showResult = false
                                        selectedOption = null
                                    }
                                },
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(text = option)
                            }
                        }
                    }

                    if (showResult) {
                        val correctAnswer =
                            currentQuestion.options[currentQuestion.correctAnswerIndex]
                        val answerColor =
                            if (selectedOption == correctAnswer) Color.Green else Color.Red
                        Text(
                            text = if (selectedOption == correctAnswer) "Correct!" else "Incorrect! Correct answer: $correctAnswer",
                            color = answerColor,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                } else {
                    Text(
                        text = "Quiz Completed!",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            }


            item {

                Button(
                    onClick = {

                        val uri = Uri.parse("https://teacher.co.ke/2021-2022-form-1-end-term-1-exams-set-1/")
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("Access End Term 1 Exams (Set 1)")
                }
            }

            item {
                Button(
                    onClick = { navController.navigate(ROUTE_HOME) },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("Back to Home")
                }
            }



        }
    }
}

@Preview
@Composable
private fun PreviewHistory() {
   History(navController = rememberNavController())
    }

