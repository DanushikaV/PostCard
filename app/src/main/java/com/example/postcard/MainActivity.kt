package com.example.postcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postcard.ui.theme.PostcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PostcardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Welcome to CSI",
                        from = " From CSI Staff"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 36.sp,
            lineHeight = 45.sp
        )
    }
}

@Composable
fun GreetingImage(message: String,from: String, modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.csi_img)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )

        GreetingText(
            message = message,
            from = from,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostcardTheme {
        GreetingImage(
            message = "Welcome to CSI",
            from = "From CSI Staff"
        )
    }
}