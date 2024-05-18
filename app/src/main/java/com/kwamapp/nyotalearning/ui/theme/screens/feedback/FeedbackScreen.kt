package com.kwamapp.nyotalearning.ui.theme.screens.feedback

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.kwamapp.nyotalearning.data.Feedback
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FeedbackScreen(navController: NavHostController) {
    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val feedbackState = remember { mutableStateOf("") }

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = feedbackState.value,
            onValueChange = { feedbackState.value = it },
            label = { Text("Feedback") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                // Dismiss the keyboard when done is clicked
                keyboardController?.hide()
            })
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val name = nameState.value
                val email = emailState.value
                val feedback = feedbackState.value
                val feedbackData = Feedback(name, email, feedback)

                // Add feedback data to Firestore
                coroutineScope.launch {
                    addFeedbackToFirestore(feedbackData)
                    showToast(context, "Feedback submitted successfully!")
                    navController.navigate(ROUTE_HOME)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit Feedback")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                navController.navigate(ROUTE_HOME)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cancel")
        }
    }
}

private suspend fun addFeedbackToFirestore(feedback: Feedback) {
    val db = FirebaseFirestore.getInstance()
    db.collection("feedback")
        .add(feedback)
        .await()
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
fun PreviewFeedbackScreen() {
    FeedbackScreen(navController = rememberNavController())
}
