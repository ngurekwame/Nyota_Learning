package com.kwamapp.nyotalearning.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kwamapp.nyotalearning.navigation.ROUTE_SWA
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.navigation.ROUTE_BIO
import com.kwamapp.nyotalearning.navigation.ROUTE_CHEM
import com.kwamapp.nyotalearning.navigation.ROUTE_ENG
import com.kwamapp.nyotalearning.navigation.ROUTE_HIST
import com.kwamapp.nyotalearning.navigation.ROUTE_MATH
import com.kwamapp.nyotalearning.navigation.ROUTE_PHY
import com.kwamapp.nyotalearning.ui.theme.AppColor


@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColor.Gold
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to the Nyota Learning App!",
                color = AppColor.DarkBlue,
                modifier = Modifier
                    .padding(bottom = 32.dp)
            )

            Text(
                text = "Please choose your subject of study",
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = { navController.navigate(ROUTE_SWA) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Kiswahili")
            }

            Button(
                onClick = { navController.navigate(ROUTE_ENG) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "English")
            }

            Button(
                onClick = { navController.navigate(ROUTE_MATH) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Mathematics")
            }
            Button(
                onClick = { navController.navigate(ROUTE_BIO) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Biology")
            }
            Button(
                onClick = { navController.navigate(ROUTE_CHEM) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Chemistry")
            }
            Button(
                onClick = { navController.navigate(ROUTE_PHY)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Physics")
            }
            Button(
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
