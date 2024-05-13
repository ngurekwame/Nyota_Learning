package com.kwamapp.nyotalearning.ui.theme.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kwamapp.nyotalearning.R
import com.kwamapp.nyotalearning.navigation.ROUTE_HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.logofile),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
        Text(text = "Let's learn to be stars".uppercase())
    }
}

@Preview
@Composable
private fun Presplash() {
   SplashScreen(navController = rememberNavController())
}