package com.example.pertemuan8.Navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.ui.view.viewmodel.MahasiswaViewModel
import com.example.pertemuan8.ui.view.viewmodel.RencanaStudyView


enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun NavigationControl (
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyView = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uistate by krsViewModel.statusUI.collectAsState()

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
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(
            route = Halaman.Matakuliah.name
        ){
            RencanaStudyView(
                mahasiswa = mahasiswaUIState,
                onSubmitButtonClicked = {
                    krsViewModel.saveDataKRS(it)
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