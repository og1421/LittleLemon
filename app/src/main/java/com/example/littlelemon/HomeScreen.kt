package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen (navController: NavController) {
    val context = LocalContext.current
    Column {
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(Color(0XFF495E57))
                .padding(start = 12.dp, end = 12.dp, top = 36.dp, bottom = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xfff4ce14),
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
            Text(
                text = stringResource(R.string.location),
                fontSize = 24.sp,
                color = Color(0xFFEDEFEE),
                modifier = Modifier.padding(start = 20.dp)
            )

            Row(
                Modifier
                    .padding(18.dp)
            ) {
                Text(
                    text = stringResource(R.string.description_one),
                    Modifier.width(200.dp),
                    color = Color(0xFFEDEFEE),
                    fontSize = 18.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.restaurantfood),
                    contentDescription = "Upper Panel Image",
                    Modifier
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            Button(
                onClick = {
                    navController.navigate(Menu.route)
                },
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(Color(0Xfff4ce14))
            ) {
                Text(
                    text = stringResource(R.string.order),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )
            }
        }
        LowerPanel()
    }
}

@Composable
private fun LowerPanel() {
    Column {
        WeeklySpecialCard()
        MenuDish()
    }
}


@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun MenuDish() {
//    LazyColumn {
//        items(Dishes) { Dish ->
//            MenuDish(Dish)
//        }
//    }
}