package com.kwamapp.nyotalearning.ui.theme.screens.home

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.R
import com.kwamapp.nyotalearning.navigation.ROUTE_ABOUT
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_CHEM
import com.kwamapp.nyotalearning.navigation.ROUTE_DOWNLOAD
import com.kwamapp.nyotalearning.navigation.ROUTE_ENG
import com.kwamapp.nyotalearning.navigation.ROUTE_FEEDBACK
import com.kwamapp.nyotalearning.navigation.ROUTE_HIST
import com.kwamapp.nyotalearning.navigation.ROUTE_MATH
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import com.kwamapp.nyotalearning.navigation.ROUTE_SWA
import com.kwamapp.nyotalearning.navigation.ROUTE_UPLOAD
import com.kwamapp.nyotalearning.ui.theme.AppColor

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
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

            SubjectCard("Kiswahili", navController, ROUTE_SWA)
            SubjectCard("English", navController, ROUTE_ENG)
            SubjectCard("Mathematics", navController, ROUTE_MATH)
            SubjectCard("Biology", navController, ROUTE_BIO)
            SubjectCard("Chemistry", navController, ROUTE_CHEM)
            SubjectCard("Physics", navController, ROUTE_PHY)
            SubjectCard("History and Government", navController, ROUTE_HIST)

            AboutCard(navController)
            FeedbackCard(navController)
            UploadCard(navController)
            DownloadCard(navController)
        }

        // Exit app button
        IconButton(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_exit),
                contentDescription = "Exit Icon",
                tint = AppColor.DarkBlue,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun SubjectCard(subject: String, navController: NavHostController, route: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route) },
        colors = CardDefaults.cardColors(containerColor = AppColor.Gold)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = subject, color = AppColor.DarkBlue)
        }
    }
}

@Composable
fun AboutCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(ROUTE_ABOUT) },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_about),
                contentDescription = "About Icon",
                tint = AppColor.DarkBlue,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "About", color = AppColor.DarkBlue, fontSize = 18.sp)
        }
    }
}

@Composable
fun FeedbackCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(ROUTE_FEEDBACK) },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_feedback),
                contentDescription = "Feedback Icon",
                tint = AppColor.DarkBlue,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Feedback", color = AppColor.DarkBlue, fontSize = 18.sp)
        }
    }
}

@Composable
fun DownloadCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(ROUTE_DOWNLOAD) },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = "Download Icon",
                tint = AppColor.DarkBlue,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Download", color = AppColor.DarkBlue, fontSize = 18.sp)
        }
    }
}

@Composable
fun UploadCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(ROUTE_UPLOAD) },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_upload),
                contentDescription = "Upload Icon",
                tint = AppColor.DarkBlue,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Upload", color = AppColor.DarkBlue, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}
