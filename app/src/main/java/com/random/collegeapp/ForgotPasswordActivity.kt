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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.random.collegeapp.ui.theme.CollegeAppTheme

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollegeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 100.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Reset Password",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
        )
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = "Enter the email associated with your account and we will send an email with instruction to reset your password"
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text(text = "Email Address") }
        )

        Button(
            onClick = {
                context.startActivity(Intent(context, CheckEmailActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            Text(text = "Send Instructions")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview2() {
    CollegeAppTheme {
        Greeting2("Android")
    }
}