package com.example.littlelemon

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(
                id = R.drawable.littlelemonlogo
            ),
            contentDescription = "Logo Image",
            modifier = Modifier
                .padding(10.dp)
        )

        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username")},
            modifier = Modifier
                .padding(10.dp)
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(10.dp)

        )

        Button(
            onClick = {
                Log.d("AAA", username.text)
                Log.d("AAA", password.text)

                if (username.text == "orlando" && password.text == "1234") {
                    Toast.makeText(context, "Welcome to Little Lemon!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Invalid credentials." + "Please try again.", Toast.LENGTH_LONG).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            )
        ) {
            Text( text = "Login", color = Color(0xFFEDEFEE))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}