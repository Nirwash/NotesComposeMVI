package com.example.notesmvi.presentation.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesmvi.R

@Composable
fun ErrorItem(
    errorMessage: String?,
    onButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = errorMessage ?: "Oh... something went wrong!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Box(modifier = Modifier
            .clickable { onButtonClicked() }
            .padding(vertical = 16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = "refresh",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}