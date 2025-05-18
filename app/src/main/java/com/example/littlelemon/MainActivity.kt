package com.example.littlelemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
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
//    Scaffold (
//        topBar = {
//            TopAppBar()
//        },
//        bottomBar = {
//            MyBottonNavigation(navController = rememberNavController())
//        }
//     ){
//        Box( modifier = Modifier
//            .fillMaxSize()
//            .padding(it)) {
//            MyNavigation()
//        }
//    }
    ScrollableGaleryScreen()

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

@Composable
fun MyBottonNavigation(navController: NavController) {

    val destinationList = listOf(
        Menu,
        Home,
        Location
    )

    val selectIndex = rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        destinationList.forEachIndexed { index, destination ->
            NavigationBarItem(
                label = { Text(destination.title) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title
                    )
                },
                selected = index == selectIndex.value,
                onClick = {
                    selectIndex.value = index
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LittleLemonPreview() {
    LittleLemonTheme {
        AppScreen()
    }
}