package com.random.collegeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.random.collegeapp.ui.theme.CollegeAppTheme

class CheckEmailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollegeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {

    var context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 50.dp)
            .fillMaxSize()
    ) {
        Icon(
            Icons.Rounded.Email, contentDescription = "Email Icon",
            modifier = Modifier
                .size(120.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = "Check you mail",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        )
        Text(
            text = "We have sent a password recover instruction to email ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        ) {
            Text(text = "Open Email App")
        }

        TextButton(
            onClick = {
                context.startActivity(Intent(context, CreateNewPass::class.java))
            },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        ) {
            Text("Skip, I'll confirm later")
        }

        Text(
            buildAnnotatedString {
                append("Didn't receive the email? Check your spam mail or ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue, )) {
                    append("try another email address")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 30.dp)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CollegeAppTheme {
        Greeting3("Android")
    }
}