package com.example.roomdatabase.viewmodel.provider

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.roomdatabase.repositori.AplikasiSiswa
import com.example.roomdatabase.viewmodel.EntryViewModel
import com.example.roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = ViewModelProvider.Factory { key, _ ->
        when (key) {
            HomeViewModel::class.java.name -> HomeViewModel(
                (getApplication() as AplikasiSiswa).container.repositoriSiswa
            )
            EntryViewModel::class.java.name -> EntryViewModel(
                (getApplication() as AplikasiSiswa).container.repositoriSiswa
            )
            else -> throw IllegalArgumentException("Unknown ViewModel: $key")
        }
    }

    private fun getApplication(): Application {
        // Tidak bisa diakses langsung — ini hanya contoh struktur
        // Sebaiknya gunakan viewModel() langsung di Composable
        TODO("Use Hilt or AndroidViewModel instead")
    }
}