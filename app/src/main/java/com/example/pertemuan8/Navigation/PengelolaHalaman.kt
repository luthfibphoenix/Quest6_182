package com.example.pertemuan8.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.ui.view.sceen.SplashView
import com.example.pertemuan8.ui.view.viewmodel.MahasiswaViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun NavigationControl (
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = ViewModel(),
    krsViewModel: RencanaStudiViewModel = ViewModel(),
){
    val uistate by ViewModel.mahasiswaUIState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(
            route = Halaman.Splash.name
        ){
            SplashView(
                onMulaiButton = {
                    navController.navigate(Halaman.Mahasiswa.name)
                }
            )
        }
        composable(
            route = Halaman.Mahasiswa.name
        ){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    viewModel.setMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(
            route = Halaman.Matakuliah.name
        ){
            MatakuliahView(
                uiState = uistate,
                onSimpanButtonClicked = {
                    viewModel.setMatakuliah(it)
                    navController.navigate(Halaman.Tampil.name)
                },
            )
        }
        composable(
            route = Halaman.Tampil.name
        ){
            TampilView(
                uiState = uistate,
                onBackButtonClicked = {navController.popBackStack()},
                onResetButtonClicked = {navController.navigate(Halaman.Splash.name)}
            )
        }
    }
}