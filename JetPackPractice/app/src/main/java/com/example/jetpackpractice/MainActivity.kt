package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.ui.theme.JetPackPracticeTheme
import com.example.jetpackpractice.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
    //    printText()
            printLoop()
        }
    }
}
@Composable
fun printText(){
Column() {
    Text(text = "Hello puspom", fontSize = 50.sp, color =Purple200)
    Text(text = "Hello sourav", fontSize = 50.sp, color =Purple200)

    Text(text = "Hello rahi", fontSize = 50.sp, color =Purple200)

    Text(text = "Hello jarif", fontSize = 50.sp, color =Purple200)
}

}

@Composable
fun printLoop(){
    val name = listOf<String>("sourav","payel","puspom","anupom")
Column() {
    for (a in name){
        Text(text = "${a}", fontSize = 30.sp)
    }
}
}
