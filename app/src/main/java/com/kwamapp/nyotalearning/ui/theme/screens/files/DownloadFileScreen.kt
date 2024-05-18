package com.kwamapp.nyotalearning.ui.theme.screens.files

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import kotlinx.coroutines.tasks.await

@Composable
fun DownloadFileScreen(navController: NavHostController) {
    val context = LocalContext.current
    val fileNames = remember { mutableStateListOf<String>() }
    val storage = Firebase.storage
    val storageRef = storage.reference.child("uploads")

    LaunchedEffect(Unit) {
        try {
            val result = storageRef.listAll().await()
            val names = result.items.map { it.name }
            fileNames.addAll(names)
        } catch (e: Exception) {
            // Handle error
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Available files for download")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        fileNames.forEach { fileName ->
            Text(
                text = fileName,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        downloadFile(context, fileName)
                    }
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        OutlinedButton(
            onClick = { navController.navigate(ROUTE_HOME) },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = "Back to Home")
        }
    }
}

private fun downloadFile(context: Context, fileName: String) {
    val storage = Firebase.storage
    val storageRef = storage.reference.child("uploads/$fileName")

    // Handle file download logic
    storageRef.downloadUrl.addOnSuccessListener { uri ->
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    }.addOnFailureListener { exception ->
        // Handle any errors
    }
}

@Preview
@Composable
fun PreviewDownloadFileScreen() {
    DownloadFileScreen(rememberNavController())
}
