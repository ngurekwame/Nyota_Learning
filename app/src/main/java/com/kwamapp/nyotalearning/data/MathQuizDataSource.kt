import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.kwamapp.nyotalearning.data.QuizQuestion
import java.math.BigDecimal
import java.math.RoundingMode

object MathQuizDataSource {

    // Define a function to load math quiz questions
    fun loadQuizQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion(
                question = "What is the value of 2 + 2?",
                options = listOf("3", "4", "5"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Simplify the expression: (5 + 3) × 2",
                options = listOf("16", "18", "20"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Calculate the square root of 144",
                options = listOf("10", "12", "15"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is 25 ÷ 5?",
                options = listOf("4", "5", "6"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Evaluate: 3 × (4 + 2)",
                options = listOf("15", "18", "20"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Find the value of 7²",
                options = listOf("42", "49", "56"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the result of 10 - 3?",
                options = listOf("6", "7", "8"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Simplify: 20 ÷ (4 × 2)",
                options = listOf("2", "2.5", "5"),
                correctAnswerIndex = 0
            ),
            QuizQuestion(
                question = "Calculate: (9 - 3) ÷ (2 + 1)",
                options = listOf("2", "2.5", "3"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "What is the value of 3² - 2²?",
                options = listOf("1", "5", "9"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Calculate: (15 + 7) ÷ 4",
                options = listOf("4", "5", "6"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Simplify: 6 × (4 - 2)",
                options = listOf("8", "10", "12"),
                correctAnswerIndex = 2
            ),
            QuizQuestion(
                question = "Find the value of 17 ÷ (4 + 3)",
                options = listOf("2", "2.25", "2.5"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "What is the square root of 81?",
                options = listOf("8", "9", "10"),
                correctAnswerIndex = 1
            ),
            QuizQuestion(
                question = "Calculate: (18 + 27) ÷ 9",
                options = listOf("3", "5", "9"),
                correctAnswerIndex = 0
            )
            // Add more math quiz questions here...
        )
    }

    // Composable function for a basic calculator
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun Calculator() {
        var inputText by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        val keyboardController = LocalSoftwareKeyboardController.current

        Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    value = inputText,
                    onValueChange = {
                        inputText = it
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton("7") { appendToInput("7") }
                    CalculatorButton("8") { appendToInput("8") }
                    CalculatorButton("9") { appendToInput("9") }
                    CalculatorButton(" ÷ ") { appendToInput(" ÷ ") }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton("4") { appendToInput("4") }
                    CalculatorButton("5") { appendToInput("5") }
                    CalculatorButton("6") { appendToInput("6") }
                    CalculatorButton(" × ") { appendToInput(" × ") }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton("1") { appendToInput("1") }
                    CalculatorButton("2") { appendToInput("2") }
                    CalculatorButton("3") { appendToInput("3") }
                    CalculatorButton(" - ") { appendToInput(" - ") }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton("0") { appendToInput("0") }
                    CalculatorButton(".") { appendToInput(".") }
                    CalculatorButton(" = ") { calculateResult() }
                    CalculatorButton(" + ") { appendToInput(" + ") }
                }

                Button(
                    onClick = { inputText = ""; result = "" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Clear")
                }

                Text(
                    text = result,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        }
    }

    @Composable
    private fun CalculatorButton(label: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(label)
        }
    }

    private fun appendToInput(text: String) {
        // This function is used to append text to the input field
        // It's outside the @Composable function and operates on normal Kotlin variables
        // Defined outside the composable function
    }

    private fun calculateResult() {
        // This function is used to calculate the result of the input expression
        // It's outside the @Composable function and operates on normal Kotlin variables
        // Defined outside the composable function
    }
}