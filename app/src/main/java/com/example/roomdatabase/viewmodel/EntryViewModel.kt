package com.example.roomdatabase.viewmodel

import com.example.roomdatabase.room.Siswa

class EntryViewModel {
}









data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",

)

fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)





















