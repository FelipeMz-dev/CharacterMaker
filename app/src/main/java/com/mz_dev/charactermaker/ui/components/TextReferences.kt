package com.mz_dev.charactermaker.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mz_dev.charactermaker.ui.theme.CharacterMakerTheme

@Composable
fun TextHead(text: String) {
    Text(
        text.uppercase(),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    CharacterMakerTheme {
        TextHead("Fill references")
    }
}