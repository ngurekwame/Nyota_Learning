package com.kwamapp.nyotalearning.ui.theme.screens.files

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.kwamapp.nyotalearning.R
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME

@Composable
fun UploadFileScreen(navController: NavHostController) {
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var uploadStatus by remember { mutableStateOf<String?>(null) }
    var uploading by remember { mutableStateOf(false) }
    var fileName by remember { mutableStateOf("") }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                selectedFileUri = uri
                uploadStatus = null
                fileName = ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Upload a file to help others",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your file will be shared with others to aid in their studies.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                launcher.launch(Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "*/*"
                    addCategory(Intent.CATEGORY_OPENABLE)
                })
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_upload), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Select File")
        }

        selectedFileUri?.let { uri ->
            Text(
                text = "Selected file: ${getFileName(context, uri)}",
                modifier = Modifier.padding(vertical = 16.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            TextField(
                value = fileName,
                onValueChange = { fileName = it },
                label = { Text("Enter file name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Button(
            onClick = {
                selectedFileUri?.let { uri ->
                    if (fileName.isNotEmpty()) {
                        uploading = true
                        uploadFile(context, uri, fileName) { status ->
                            uploadStatus = status
                            uploading = false
                        }
                    } else {
                        uploadStatus = "Please enter a file name"
                    }
                }
            },
            enabled = selectedFileUri != null && !uploading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Upload File")
        }

        if (uploading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        } else {
            uploadStatus?.let { status ->
                Text(
                    text = status,
                    modifier = Modifier.padding(vertical = 16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (status.startsWith("Upload failed")) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                )
            }
        }

        OutlinedButton(
            onClick = { navController.navigate(ROUTE_HOME) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Back to Home")
        }
    }
}

private fun getFileName(context: Context, uri: Uri): String {
    var result: String? = null
    if (uri.scheme.equals("content")) {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        try {
            if (cursor != null && cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"))
            }
        } finally {
            cursor?.close()
        }
    }
    if (result == null) {
        result = uri.lastPathSegment
    }
    return result ?: "Unknown file"
}

private fun uploadFile(context: Context, uri: Uri, fileName: String, onUploadStatus: (String) -> Unit) {
    val storage = Firebase.storage
    val storageRef = storage.reference
    val fileRef = storageRef.child("uploads/$fileName")
    val uploadTask = fileRef.putFile(uri)

    uploadTask.addOnProgressListener { taskSnapshot ->
        val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount).toFloat()
    }.addOnSuccessListener {
        onUploadStatus("File uploaded successfully")
    }.addOnFailureListener { exception ->
        onUploadStatus("Upload failed: ${exception.message}")
    }
}

@Preview
@Composable
fun PreviewUploadFileScreen() {
    UploadFileScreen(rememberNavController())
}
