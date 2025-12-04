package com.example.roomdatabase.viewmodel.provider

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase.repositori.AplikasiSiswa
import com.example.roomdatabase.viewmodel.DetailViewModel
import com.example.roomdatabase.viewmodel.EntryViewModel
import com.example.roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                repositoriSiswa = AplikasiSiswa().container.repositoriSiswa
            )
        }
        initializer {
            EntryViewModel(
                repositoriSiswa = AplikasiSiswa().container.repositoriSiswa
            )
        }
        initializer {
            DetailViewModel(this.createSavedStateHandle(),
                AplikasiSiswa().container.repositoriSiswa)
        }

        //initializer {
        //EditViewModel(this.createSavedStateHandle(), aplikasiSiswa().container.repositoriSiswa)
        //}
    }
}

fun CreationExtras.AplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application) as AplikasiSiswa