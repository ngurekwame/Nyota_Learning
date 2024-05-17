package com.kwamapp.nyotalearning.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.R
import com.kwamapp.nyotalearning.navigation.ROUTE_ABOUT
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_CHEM
import com.kwamapp.nyotalearning.navigation.ROUTE_ENG
import com.kwamapp.nyotalearning.navigation.ROUTE_FEEDBACK
import com.kwamapp.nyotalearning.navigation.ROUTE_HIST
import com.kwamapp.nyotalearning.navigation.ROUTE_MATH
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import com.kwamapp.nyotalearning.navigation.ROUTE_SWA
import com.kwamapp.nyotalearning.ui.theme.AppColor

@Composable
fun HomeScreen(navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    var selectedSubject by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logofile),
            contentDescription = "logo",
            modifier = Modifier.padding(vertical = 30.dp)
        )

        Text(
            text = "Welcome to the Nyota Learning App!".uppercase(),
            color = AppColor.DarkBlue,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Please choose your preferred subject of study",
            color = AppColor.DarkBlue,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        SubjectDropdown(
            expanded = expanded,
            selectedSubject = selectedSubject,
            onExpandedChange = { expanded = !expanded },
            onSubjectSelected = { subject ->
                selectedSubject = subject
                expanded = false
                navigateToSubject(navController, subject)
            }
        )
    }
}

@Composable
fun SubjectDropdown(
    expanded: Boolean,
    selectedSubject: String?,
    onExpandedChange: () -> Unit,
    onSubjectSelected: (String) -> Unit
) {
    val subjectOptions = listOf(
        "Kiswahili",
        "English",
        "Mathematics",
        "Biology",
        "Chemistry",
        "Physics",
        "History and Government",
        "About",
        "Feedback"
    )

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(
            onClick = onExpandedChange,
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text(text = selectedSubject ?: "Select Subject", color = Color.Blue)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onExpandedChange,
            modifier = Modifier.background(Color.White)
        ) {
            subjectOptions.forEach { subject ->
                DropdownMenuItem(
                    text = { Text(text = subject, color = AppColor.DarkBlue) },
                    onClick = {
                        onSubjectSelected(subject)
                    }
                )
            }
        }
    }
}

private fun navigateToSubject(navController: NavHostController, subject: String) {
    when (subject) {
        "Kiswahili" -> navController.navigate(ROUTE_SWA)
        "English" -> navController.navigate(ROUTE_ENG)
        "Mathematics" -> navController.navigate(ROUTE_MATH)
        "Biology" -> navController.navigate(ROUTE_BIO)
        "Chemistry" -> navController.navigate(ROUTE_CHEM)
        "Physics" -> navController.navigate(ROUTE_PHY)
        "History and Government" -> navController.navigate(ROUTE_HIST)
        "About" -> navController.navigate(ROUTE_ABOUT)
        "Feedback" -> navController.navigate(ROUTE_FEEDBACK)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}
