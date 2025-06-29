package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DishDetailsScreen(dish: Dish) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = dish.image),
            contentDescription = dish.name,
            modifier = Modifier
                .fillMaxWidth()
//                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = dish.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = dish.description)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Button(onClick = { /* Decrease */ }) { Text("-") }
                Spacer(modifier = Modifier.width(8.dp))
                Text("1", modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Increase */ }) { Text("+") }
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)),
                onClick = { /* Add item */ }
            ) {
                Text("Add for ${dish.price}")
            }
        }
    }
}

