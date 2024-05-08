import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.data.ChemQuizDataSource
import com.kwamapp.nyotalearning.model.Quiz
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import com.kwamapp.nyotalearning.navigation.ROUTE_QUIZSUMMARY
import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Chemistry(navController: NavController) {
    val notesUrl = "https://teacher.co.ke/wp-content/uploads/bsk-pdf-manager/2019/01/KCSE-FORM-1-CHEMISTRY-NOTES.pdf"
    val examMocksUrl = "https://example.com/path/to/chemistry_exam_mocks.zip"

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    val quizQuestions = remember { ChemQuizDataSource.loadQuizQuestions() }
    val context = LocalContext.current
    var quizResults by remember { mutableStateOf<List<Boolean>>(emptyList()) }
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CHEMISTRY",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            DownloadButton(
                buttonText = "Download Chemistry Notes",
                fileUrl = notesUrl,
                context = context
            )

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
                                    delay(2000)
                                    val isCorrect = option == currentQuestion.options[currentQuestion.correctAnswerIndex]
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
                    val correctAnswer = currentQuestion.options[currentQuestion.correctAnswerIndex]
                    val answerColor = if (selectedOption == correctAnswer) Color.Green else Color.Red
                    Text(
                        text = if (selectedOption == correctAnswer) "Correct!" else "Incorrect! Correct answer: $correctAnswer",
                        color = answerColor,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            } else {
                // Quiz completed
                DownloadButton(
                    buttonText = "Download Chemistry Exam Mocks",
                    fileUrl = examMocksUrl,
                    context = context
                )
                Text(
                    text = "Quiz Completed!",
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Button(
                    onClick = {
                        quizResults = List(quizQuestions.size) { index ->
                            index % 2 == 0  // Simulate half correct, half incorrect
                        }
                        navController.navigate(ROUTE_QUIZSUMMARY)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("View Summary")
                }
            }

            Button(
                onClick = { navController.navigate(ROUTE_BIO) },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Go to Biology")
            }

            Button(
                onClick = { navController.navigate(ROUTE_PHY) },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Go to Physics")
            }

            Button(
                onClick = { navController.navigate(ROUTE_HOME) },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Back to Home")
            }
        }
    }
}

@Composable
fun DownloadButton(buttonText: String, fileUrl: String, context: android.content.Context) {
    val scope = rememberCoroutineScope()

    Button(
        onClick = {
            scope.launch {
                downloadFile(context, fileUrl)
            }
        },
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(buttonText)
    }
}

private suspend fun downloadFile(context: android.content.Context, fileUrl: String) {
    val fileName = fileUrl.substringAfterLast('/')
    try {
        val url = java.net.URL(fileUrl)
        val connection = withContext(Dispatchers.IO) { url.openConnection().getInputStream() }
        val file = java.io.File(context.cacheDir, fileName)
        file.outputStream().use { output ->
            connection.copyTo(output)
        }
        println("File downloaded: ${file.absolutePath}")
    } catch (e: Exception) {
        println("File download failed: ${e.message}")
    }
}

@Preview
@Composable
private fun PreviewChemistry() {
    Chemistry(navController = rememberNavController())
}
