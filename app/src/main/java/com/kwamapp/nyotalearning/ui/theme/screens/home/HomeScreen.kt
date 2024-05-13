package com.kwamapp.nyotalearning.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.R
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_CHEM
import com.kwamapp.nyotalearning.navigation.ROUTE_ENG
import com.kwamapp.nyotalearning.navigation.ROUTE_HIST
import com.kwamapp.nyotalearning.navigation.ROUTE_MATH
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import com.kwamapp.nyotalearning.navigation.ROUTE_SWA
import com.kwamapp.nyotalearning.ui.theme.AppColor


@Composable
fun HomeScreen(navController: NavHostController) {
    val scrollState= rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColor.Gold)
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logofile),
                contentDescription = "logo")
            Spacer(modifier = Modifier.padding(30.dp))

            Text(
                text = "Welcome to the Nyota Learning App!".uppercase(),
                color = AppColor.DarkBlue,
                modifier = Modifier
                    .padding(bottom = 32.dp)

            )

            Text(
                text = "Please choose your preferred subject of study".uppercase(),
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            OutlinedButton(
                onClick = { navController.navigate(ROUTE_SWA) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Kiswahili")
            }

            OutlinedButton(
                onClick = { navController.navigate(ROUTE_ENG) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "English")
            }

            OutlinedButton(
                onClick = { navController.navigate(ROUTE_MATH) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Mathematics")
            }
            OutlinedButton(
                onClick = { navController.navigate(ROUTE_BIO) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Biology")
            }
            OutlinedButton(
                onClick = { navController.navigate(ROUTE_CHEM) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Chemistry")
            }
            OutlinedButton(
                onClick = { navController.navigate(ROUTE_PHY)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Physics")
            }
            OutlinedButton(
                onClick = { navController.navigate(ROUTE_HIST) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "History and Government")
            }

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}
