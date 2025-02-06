package com.example.bucs501_2_4

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bucs501_2_4.ui.theme.BUCS501_2_4Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BUCS501_2_4Theme {
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember {SnackbarHostState()}
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }
                ) { innerPadding ->
                    Profile(
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState = snackbarHostState,
                        scope = scope
                    )
                }
            }
        }
    }
}

@Composable
fun Profile(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState,
            scope: CoroutineScope,) {

    Column (modifier = modifier
        .fillMaxSize().background(Color(255,192,203))
    ){
        Text(
            text = "Person",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
            )
        HorizontalDivider(thickness = 5.dp)
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.align(Alignment.CenterHorizontally).clip(CircleShape).size(400.dp)
        )
        Row(
            modifier = modifier.background(Color(255,140,200)).fillMaxSize()
        ){
            Column(
                modifier = Modifier.background(Color(255,255,255)).fillMaxHeight().width(206.dp)
            ){
                Text(text = "Information : ")
                Text("Boston University Student")
                Text("Age 98")
                Text("Bald")
                Text("Plays Basketball")
            }

            Button(
                onClick = {scope.launch {
                    snackbarHostState.showSnackbar("Following")
                }},
                modifier = Modifier.fillMaxSize().padding(20.dp)
            ){
                Text(
                    "Follow",
                    fontSize = 30.sp,
                    )
            }
        }
    }
}

