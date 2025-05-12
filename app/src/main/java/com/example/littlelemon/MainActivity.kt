package com.example.littlelemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun AppScreen() {
    Scaffold (
        topBar = {
            TopAppBar()
        }
    ){
        Box( modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            MyNavigation()
        }
    }

}

@Composable
fun MyNavigation (){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(Home.route) {
            HomeScreen(navController = navController)
        }
        composable (Menu.route){
            MenuListScreen()
        }
    }
}


//@Composable
//fun MenuContent(paddingValues: PaddingValues) {
//    Surface(modifier = Modifier.padding(paddingValues)) {
//        val menuPadding = 8.dp
//        val configuration = LocalConfiguration.current
//        when (configuration.orientation) {
//            ORIENTATION_LANDSCAPE -> {
//                Column {
//                    Row(modifier = Modifier.weight(0.5f)) {
//                        Text(
//                            "Appetizers",
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(Purple80)
//                                .padding(menuPadding)
//                        )
//                        Text(
//                            "Salads",
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .padding(menuPadding)
//                        )
//                    }
//                    Row(modifier = Modifier.weight(0.5f)) {
//                        Text(
//                            "Drinks",
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(Pink80)
//                                .padding(menuPadding)
//                        )
//                        Text(
//                            "Mains",
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(PurpleGrey80)
//                                .padding(menuPadding)
//                        )
//                    }
//                }
//            }
//            else -> {
//                Column {
//                    Text(
//                        "Appetizers",
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(Purple80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Salads",
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Drinks",
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(Pink80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Mains",
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(PurpleGrey80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun LittleLemonPreview() {
    LittleLemonTheme {
        AppScreen()
    }
}