package com.example.notesmvi.presentation.screen.main

import com.example.notesmvi.domain.model.NoteModel
import com.example.notesmvi.presentation.screen.base.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class MainScreenState(
    val isLoading: Boolean,
    val data: List<NoteModel>,
    val error: String? = null
) : UiState {
    companion object {
        fun initial() = MainScreenState(
            isLoading = true,
            data = emptyList(),
            error = null
        )
    }
}
