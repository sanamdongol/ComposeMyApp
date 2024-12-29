package com.random.collegeapp

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.random.collegeapp.ui.theme.CollegeAppTheme

class CreateNewPass : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollegeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 100.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Create New Password",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
        )
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = "Your new password must be different from previous used passwords."
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text(text = "Password") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text(text = "Confirm Password") }
        )

        Button(onClick = {}, modifier = Modifier
            .padding(top = 20.dp)
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()) {
            Text("Reset Password")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    CollegeAppTheme {
        Greeting4()
    }
}