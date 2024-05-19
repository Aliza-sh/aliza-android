package com.aliza.alizaandroid.ui

import android.util.Log
import com.aliza.alizaandroid.model.MainRepository
import com.aliza.alizaandroid.model.data.StudentUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class MainViewModel(mainRepository: MainRepository) {

    val dataStudents: Flow<StudentUi> =
        mainRepository.getAllFromApi()
            .map {
                StudentUi(it.id, it.name, it.familyName, it.grade)
            }
            .filter {
                it.name.endsWith("3")
            }
            .catch {
                Log.v("testFlow", it.message ?: "null message")
            }
}