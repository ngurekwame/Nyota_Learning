import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.data.BioNotes
import com.kwamapp.nyotalearning.data.BioQuizDataSource
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Biology(navController: NavController) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    val quizQuestions = remember { BioQuizDataSource.loadQuizQuestions() }
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf<String?>(null) }
    val subjectName = "Biology"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA))
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = subjectName.uppercase(),
                    color = Color(0xFF00796B),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                Text(
                    text = "$subjectName Notes".uppercase(),
                    color = Color(0xFF004D40),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(BioNotes.sections) { section ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = section.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF00796B)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = section.content,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF004D40)
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.padding(30.dp))
                Text(
                    text = "Quiz time".uppercase(),
                    color = Color(0xFF00796B),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                if (currentQuestionIndex < quizQuestions.size) {
                    val currentQuestion = quizQuestions[currentQuestionIndex]

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = currentQuestion.question,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(0xFF00796B),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            currentQuestion.options.forEach { option ->
                                Button(
                                    onClick = {
                                        selectedOption = option
                                        showResult = true

                                        GlobalScope.launch {
                                            delay(1000)
                                            val isCorrect = option == currentQuestion.options[currentQuestion.correctAnswerIndex]
                                            if (isCorrect) {
                                                currentQuestionIndex++
                                            }
                                            showResult = false
                                            selectedOption = null
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(text = option, color = Color.White)
                                }
                            }

                            if (showResult) {
                                val correctAnswer = currentQuestion.options[currentQuestion.correctAnswerIndex]
                                val answerColor = if (selectedOption == correctAnswer) Color.Green else Color.Red
                                Text(
                                    text = if (selectedOption == correctAnswer) "Correct!" else "Incorrect! Correct answer: $correctAnswer",
                                    color = answerColor,
                                    modifier = Modifier.padding(vertical = 8.dp)
                                )
                            }
                        }
                    }
                } else {
                    Text(
                        text = "Quiz Completed!",
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineMedium,
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
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("Access End Term 1 Exams (Set 1)", color = Color.White)
                }
            }

            item {
                Button(
                    onClick = { navController.navigate(ROUTE_HOME) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("Back to Home", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBio() {
    Biology(navController = rememberNavController())
}
