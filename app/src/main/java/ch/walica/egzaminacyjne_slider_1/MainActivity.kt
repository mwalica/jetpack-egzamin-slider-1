package ch.walica.egzaminacyjne_slider_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ch.walica.egzaminacyjne_slider_1.ui.theme.Egzaminacyjne_slider_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Egzaminacyjne_slider_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val greetings = listOf("Dzień dobry", "Good morning", "Buenos dias")
    var index by remember {
        mutableStateOf(0)
    }

    var sliderSize by remember {
        mutableStateOf(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Właściwości czcionki",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF558B2F)),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp


        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Rozmiar ${(sliderSize * 40).toInt()}", modifier = Modifier.fillMaxWidth())
        Slider(
            value = sliderSize, onValueChange = {
                sliderSize = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = greetings[index],
            fontSize = (sliderSize * 40).toInt().sp,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (index == greetings.size - 1) {
                    index = 0
                } else {
                    index++
                }
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF558B2F),
                contentColor = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) {
            Text(text = ">>", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Egzaminacyjne_slider_1Theme {
        MainScreen()
    }
}