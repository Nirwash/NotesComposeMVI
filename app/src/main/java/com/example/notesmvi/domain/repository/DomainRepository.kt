package com.example.notesmvi.domain.repository

import com.example.notesmvi.domain.model.NoteModel

interface DomainRepository {
    suspend fun getAllNotes(): List<NoteModel>
}