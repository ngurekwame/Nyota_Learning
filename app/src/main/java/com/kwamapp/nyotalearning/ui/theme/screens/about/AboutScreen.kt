import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
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
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import com.kwamapp.nyotalearning.ui.theme.AppColor

@Composable
fun About(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColor.Cream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hero Image
            Image(
                painter = painterResource(id = R.drawable.logofile),
                contentDescription = "Hero Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 30.dp)
            )

            Text(
                text = "About Our App",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Text(
                text = "Founded in 2020, our app aims to provide...",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Executives:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "- CEO: John Doe (Bio: Insert CEO Bio Here)",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "- CTO: Jane Smith (Bio: Insert CTO Bio Here)",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            Text(
                text = "Contact Us:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "- Email: contact@example.com",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            Text(
                text = "Follow Us:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "- Twitter: @example",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "- Facebook: /example",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "- Instagram: @example",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedButton(
                onClick = { navController.navigate(ROUTE_HOME) },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Back to Home")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAboutScreen() {
    About(rememberNavController())
}
