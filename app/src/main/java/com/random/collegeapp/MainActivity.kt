package com.random.collegeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.random.collegeapp.ui.theme.CollegeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollegeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Define text state
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 50.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Welcome back!\nYou have been missed",
            style = TextStyle(fontSize = 25.sp, color = Color.Black,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 50.dp)
        )

        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Email") },
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Password") },
            modifier = Modifier

                .fillMaxWidth()
        )

        TextButton(
            onClick = {
                context.startActivity(Intent(context,
                    ForgotPasswordActivity::class.java))
            },
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(top = 15.dp)

        ) {
            Text("Forgot Password")
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text("Login")
        }
        Text(
            buildAnnotatedString {
                append("Don't have an account? ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,
                    color = Color.Blue)) {
                    append("Sign Up")
                }
            },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 30.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    CollegeAppTheme {
        Greeting("Android")
    }
}
