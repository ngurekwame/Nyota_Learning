import MathQuizDataSource.Calculator
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.model.Quiz
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import kotlinx.coroutines.delay

@Composable
fun Mathematics(navController: NavController) {
    var subjectname = "Mathematics"
    val notesUrl = "https://teacher.co.ke/wp-content/uploads/bsk-pdf-manager/2019/01/KCSE-FORM-1-CHEMISTRY-NOTES.pdf"
    val examMocksUrl = "https://example.com/path/to/chemistry_exam_mocks.zip"

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    val quizQuestions = remember { MathQuizDataSource.loadQuizQuestions() }

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
                text = subjectname,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            DownloadButton(
                buttonText = "Download $subjectname Notes",
                fileUrl = notesUrl,
                context = LocalContext.current
            )

            if (currentQuestionIndex < quizQuestions.size) {
                val currentQuestion = quizQuestions[currentQuestionIndex]
                Quiz(
                    quizQuestion = currentQuestion,
                    onAnswerSelected = { selectedOption ->
                        val isCorrect = "selectedOption" == currentQuestion.options[currentQuestion.correctAnswerIndex]
                        showResult = true

                        if (isCorrect) {
                            Text("Correct!", color = Color.Green)
                        } else {
                            Text(
                                "Incorrect! The correct answer is ${currentQuestion.options[currentQuestion.correctAnswerIndex]}",
                                color = Color.Red
                            )
                        }

                        LaunchedEffect(Unit) {
                            delay(2000)
                            currentQuestionIndex++
                            showResult = false
                        }
                    }
                )
            } else {
                DownloadButton(
                    buttonText = "Download $subjectname Exam Mocks",
                    fileUrl = examMocksUrl,
                    context = LocalContext.current
                )
                Text(
                    text = "Quiz Completed!",
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Button(
                    onClick = { /* Navigate to quiz summary screen */ },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("View Summary")
                }
            }

            // Add the Calculator component
            Calculator() // This will display the calculator

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

@Preview
@Composable
private fun PreviewMathematics() {
    Mathematics(rememberNavController())
}
