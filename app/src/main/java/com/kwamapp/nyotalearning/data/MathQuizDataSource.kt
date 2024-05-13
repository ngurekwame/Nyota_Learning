import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kwamapp.nyotalearning.R
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
                correctAnswerIndex = 0
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
    fun Calc() {
        var firstnum by remember { mutableStateOf(TextFieldValue("")) }
        var secondnum by remember { mutableStateOf(TextFieldValue("")) }
        var answer by remember { mutableStateOf("") }
        val context= LocalContext.current

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
                .padding(16.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = firstnum,
                label = { Text(text = "Enter First No", color = Color.White, fontSize = 30.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { firstnum = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = secondnum,
                label = { Text(text = "Enter Second No", color = Color.White, fontSize = 30.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { secondnum = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(bottom = 16.dp)
            )


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Answer: $answer",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                OperationButton("+", Color.Blue) {
                    answer = performOperation(firstnum.text, secondnum.text) { a, b -> a + b }
                }
                OperationButton("-", Color.Blue) {
                    answer = performOperation(firstnum.text, secondnum.text) { a, b -> a - b }
                }
                OperationButton("*", Color.Blue) {
                    answer = performOperation(firstnum.text, secondnum.text) { a, b -> a * b }
                }
                OperationButton("/", Color.Blue) {
                    answer = performOperation(firstnum.text, secondnum.text) { a, b -> if (b.toInt() != 0) a / b else "Infinity" }
                }
            }
        }
    }

    @Composable
    fun OperationButton(text: String, color: Color, onClick: () -> Unit) {
        OutlinedButton(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(color),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(48.dp)

        ) {
            Text(text = text, fontSize = 24.sp)
        }
    }

    fun performOperation(first: String, second: String, operation: (Double, Double) -> Any): String {
        val firstNum = first.toDoubleOrNull()
        val secondNum = second.toDoubleOrNull()
        return if (firstNum != null && secondNum != null) {
            operation(firstNum, secondNum).toString()
        } else {
            "Invalid Input"
        }
        }}