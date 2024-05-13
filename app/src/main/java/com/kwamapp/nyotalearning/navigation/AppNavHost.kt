package com.kwamapp.nyotalearning.navigation


import Biology
import Chemistry
import English
import History
import com.kwamapp.nyotalearning.ui.theme.screens.subjects.Kiswahili
import com.kwamapp.nyotalearning.ui.theme.screens.subjects.Mathematics
import com.kwamapp.nyotalearning.ui.theme.screens.subjects.Physics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kwamapp.nyotalearning.ui.theme.screens.home.HomeScreen
import com.kwamapp.nyotalearning.ui.theme.screens.login.LoginScreen
import com.kwamapp.nyotalearning.ui.theme.screens.quizsummaries.QuizSummary
import com.kwamapp.nyotalearning.ui.theme.screens.registration.RegisterScreen
import com.kwamapp.nyotalearning.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {
    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_SPLASH) {
            SplashScreen(navController = navController)
            }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_BIO){
            Biology(navController)
        }
        composable(ROUTE_CHEM){
            Chemistry(navController)
        }
        composable(ROUTE_PHY){
            Physics(navController)
        }
        composable(ROUTE_HIST){
            History(navController)
        }
        composable(ROUTE_MATH){
            Mathematics(navController)
        }
        composable(ROUTE_ENG){
            English(navController)
        }
        composable(ROUTE_SWA){
            Kiswahili(navController)
        }

                // Add other subjects as needed

            }

        }

