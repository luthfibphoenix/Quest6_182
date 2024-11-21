package com.example.pertemuan8.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan8.R
import com.example.pertemuan8.model.Mahasiswa
import com.example.pertemuan8.model.RencanaStudi

@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    krs: RencanaStudi,
    onbackButtonClicked: () -> Unit,
    onResetButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(45.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Data KRS Mahasiswa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Yellow
                )
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(17.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column{
                Text(text = "NIM")
                Text(text = mahasiswa.nim)
            }
            Column{
                Text(text = "Nama")
                Text(text = mahasiswa.nama)
            }
            Column{
                Text(text = "Email")
                Text(text = mahasiswa.email)
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Mata Kuliah yang diambil:")
            Text(text = krs.namaMK)
            Row{
                Text(text = "Kelas:")
                Text(text = krs.kelas)
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = {onbackButtonClicked()}) {
                Text(text = "Kembali")
            }
            Button(onClick = {onResetButtonClicked()}) {
                Text(text = "Reset")
            }
        }
    }
}