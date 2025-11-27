package com.example.roomdatabase.repositori


import com.example.roomdatabase.room.Siswa
import kotlinx.coroutines.flow.Flow


interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)

}

class