package com.example.pertemuan8.ui.view.sceen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pertemuan8.R

@Preview(showBackground = true)

@Composable
fun SplashView(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxSize()
                .size(150.dp)
        ){
            Text(text = "Masuk")
        }
    }
}


