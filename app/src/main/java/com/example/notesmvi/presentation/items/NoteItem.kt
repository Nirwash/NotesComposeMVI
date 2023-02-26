package com.example.notesmvi.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesmvi.domain.model.NoteModel
import com.example.notesmvi.presentation.ui.theme.NotesComposeMVITheme
import java.time.LocalDate
import java.util.*


@Composable
fun NoteItem(note: NoteModel, modifier: Modifier) {
    val randomColors = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
        alpha = 30
    )
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(randomColors)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        ) {
            Column {
                Text(text = note.title, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = note.subtitle,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 2.dp)

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = note.author,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "${note.date.dayOfMonth} ${note.date.month}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    NotesComposeMVITheme {
        val note = NoteModel(
            id = 1,
            title = "Title",
            subtitle = "Subtitle",
            date = LocalDate.now(),
            author = "Author"
        )
        NoteItem(note = note, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
    }
}