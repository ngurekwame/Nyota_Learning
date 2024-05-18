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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import java.util.UUID

@Composable
fun UploadFileScreen(navController: NavHostController) {
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var uploadStatus by remember { mutableStateOf<String?>(null) }
    var uploading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                selectedFileUri = uri
                uploadStatus = null
            }
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
                Text(text = "Upload a file to help others")

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Your file will be shared with others to aid in their studies.")
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
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Select File")
        }

        // Display selected file name, if any
        selectedFileUri?.let { uri ->
            Text("Selected file: ${getFileName(context, uri)}")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                selectedFileUri?.let { uri ->
                    uploading = true
                    uploadFile(context, uri) { status ->
                        uploadStatus = status
                        uploading = false
                    }
                }
            },
            enabled = selectedFileUri != null && !uploading
        ) {
            Text("Upload File")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (uploading) {
            CircularProgressIndicator()
        } else {
            uploadStatus?.let { status ->
                Text(status)
            }
        }
        OutlinedButton(
            onClick = { navController.navigate(ROUTE_HOME) },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = "Back to Home")
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

private fun uploadFile(context: Context, uri: Uri, onUploadStatus: (String) -> Unit) {
    val storage = Firebase.storage
    val storageRef = storage.reference
    val fileRef = storageRef.child("uploads/${UUID.randomUUID()}")
    val uploadTask = fileRef.putFile(uri)

    uploadTask.addOnProgressListener { taskSnapshot ->
        val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount).toFloat()
        // You can update the UI with the upload progress if needed
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
