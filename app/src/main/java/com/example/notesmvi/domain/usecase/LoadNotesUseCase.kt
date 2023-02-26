package com.example.notesmvi.domain.usecase

import com.example.notesmvi.data.DomainRepositoryImpl
import com.example.notesmvi.domain.model.NoteModel
import javax.inject.Inject

class LoadNotesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : BaseUseCase<List<NoteModel>>() {
    override suspend fun invoke(): List<NoteModel> = domainRepository.getAllNotes()
}