package com.example.roomdatabase.viewmodel.provider

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.createViewModel
import com.example.roomdatabase.repositori.AplikasiSiswa
import com.example.roomdatabase.viewmodel.EntryViewModel
import com.example.roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = ViewModelProvider.Factory { key, creator ->
        when (key) {
            HomeViewModel::class.java.name -> HomeViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
            EntryViewModel::class.java.name -> EntryViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
            else -> throw IllegalArgumentException("Unknown ViewModel: $key")
        }
    }

    /**
     * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah
     * instance dari [AplikasiSiswa].
     */
    fun ViewModelStoreOwner.aplikasiSiswa(): AplikasiSiswa {
        return (this as? Application)?.let { application ->
            application as AplikasiSiswa
        } ?: throw IllegalStateException("Not an Application context")
    }
}