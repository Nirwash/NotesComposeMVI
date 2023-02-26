package com.example.notesmvi.data

import com.example.notesmvi.domain.model.NoteModel
import com.example.notesmvi.domain.repository.DomainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.time.LocalDate
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository {
    companion object {
        var count = 0
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        val list: List<NoteModel>
        withContext(Dispatchers.IO) {
            when (count) {
                0 -> {
                    count++
                    delay(3000)
                    list = emptyList()
                }
                1 -> {
                    count++
                    delay(10000)
                    throw ConnectException("Lost internet connection")
                }
                2 -> {
                    count = 0
                    delay(3000)
                    val mutableList = mutableListOf<NoteModel>()
                    for (i in 1..10) {
                        mutableList.add(
                            NoteModel(
                                id = i.toLong(),
                                title = "Note $i",
                                subtitle = "subtitle $i",
                                date = LocalDate.now(),
                                author = "author $i"
                            )
                        )
                    }
                    list = mutableList
                }
                else -> list = emptyList()
            }
            return@withContext
        }
        return list
    }
}