package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items


@Composable
fun  MenuListScreen() {
    Column {
//        UpperPanel()
//        PainelInferior()

        LazyRow {
            items(Categories) { category ->
                MenuCategory(category)
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
//        LazyColumn {
//            items(Dishes) { Dish->
//                MenuDish(Dish)
//            }
//        }
    }
}


@Composable
private fun UpperPanel() {
    Column(
        modifier = Modifier
            .background(Color(0xFF495E57))
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = Bold,
            color = Color(0xFFF4CE14)
        )

    }
    Text(
        text = stringResource(id = R.string.order_for_takeaway),
        fontSize = 24.sp,
        fontWeight = Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
private fun PainelInferior() {
    Column {
        LazyRow {
            items(Categories) { category ->
                MenuCategory(category)
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )
//        LazyColumn {
//            items(Dishes) { Dish ->
//                MenuDish(Dish)
//            }
//        }
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
fun MenuCategory(category: String){
    Button(
        onClick = {},
//        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(46),
        modifier = Modifier
            .padding(5.dp)

    ) {
        Text(text = category)
    }
}

@Composable
fun MenuDish(dish: Dish, onClick: (Dish) -> Unit) {
    // to be defined
    Card {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable{ onClick(dish)}
        ){
            Column {
                Text(
                    text = dish.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = dish.description,
                    Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f),
                )

                Text(
                    text = dish.price,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(id = dish.image),
                contentDescription = "Greek Salad Image",
                Modifier.clip(RoundedCornerShape(20.dp))
            )
        }
    }
    HorizontalDivider( modifier = Modifier.padding(start = 8.dp, end = 8.dp), color = Color(0xfff4ce14), thickness = 1.dp)
}

val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

data class Dish(
    val name: String,
    val price: String,
    val description: String,
    val image: Int
)

val Dishes = listOf(
    Dish(
        "Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        "Bruschetta",
        "$5.99",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(
        "Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
    Dish(
        "Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        "Bruschetta",
        "$5.99",
        "Our Brushetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(
        "Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
    Dish(
        "Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        "Bruschetta",
        "$5.99",
        "Our Brushetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(
        "Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    )
)

@Preview(showBackground = true)
@Composable
fun MenuListPreview(){
    MenuListScreen()
}
