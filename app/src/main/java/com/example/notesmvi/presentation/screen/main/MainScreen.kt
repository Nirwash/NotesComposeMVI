package com.example.notesmvi.presentation.screen.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesmvi.domain.model.NoteModel
import com.example.notesmvi.presentation.items.ErrorItem
import com.example.notesmvi.presentation.items.LoadingItem
import com.example.notesmvi.presentation.items.NoteItem

@Composable
fun MainScreen(navHostController: NavHostController) {
    val viewModel = hiltViewModel<MainViewModel>()
    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Log.d("MainScreen", "Loading...")
            LoadingItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("MainScreen", "Data size: ${state.data.size}")
            MainScreenContent(state.data)
        }
        state.error != null -> {
            Log.d("MainScreen", "Error message: ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@Composable
fun MainScreenContent(data: List<NoteModel>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                Text(
                    text = "Notes Compose/MVI App",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 12.dp, bottom = 36.dp)
                )
            }
            items(data) { item ->
                NoteItem(item, modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp))
            }
        }
    }
}
