package com.marcusmalmgren.androidv4navigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcusmalmgren.androidv4navigation.ui.theme.AndroidV4NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidV4NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

enum class NavScreen() {
    Welcome,
    ReadMore,
    Fancy
}

@Composable
fun AppNavHost(
    navController : NavHostController = rememberNavController(),
    stuffVM : StuffViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = NavScreen.Welcome.name) {
        composable(NavScreen.Welcome.name) {
            Welcome(
                stuffVM,
                goReadMore = {
                    navController.navigate(NavScreen.ReadMore.name + "/" + it)
                             },
                goFancy = { navController.navigate(NavScreen.Fancy.name) })
        }
        composable(NavScreen.ReadMore.name + "/{fruitname}") {
            val thefruit = it.arguments?.getString("fruitname")
            ReadMore(
                stuffVM,
                fruit = thefruit!!,
                goFancy = { navController.navigate(NavScreen.Fancy.name) }
            )
        }
        composable(NavScreen.Fancy.name) {
            Text(text = "Fancy")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    AndroidV4NavigationTheme {
        AppNavHost()
    }
}