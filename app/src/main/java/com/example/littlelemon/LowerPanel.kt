package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    // to be defined
    Card (modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            Modifier
                .padding(8.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MenuDish() {
    // to be defined
    Card {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Column {
                Text(
                    text = stringResource(R.string.dish_one),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = stringResource(R.string.dish_one_description),
                    Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f),
                )

                Text(
                    text = stringResource(R.string.dish_one_price),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(R.drawable.greeksalad),
                contentDescription = "Greek Salad Image",
                Modifier.clip(RoundedCornerShape(20.dp))
            )
        }
    }
    HorizontalDivider( modifier = Modifier.padding(start = 8.dp, end = 8.dp), color = Color.LightGray, thickness = 1.dp)
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
