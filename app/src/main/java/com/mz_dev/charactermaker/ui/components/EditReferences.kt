package com.mz_dev.charactermaker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mz_dev.charactermaker.ui.theme.CharacterMakerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextReference(text: String, reference: String, callbackReference: (String) -> Unit) {
    TextField(
        value = reference,
        onValueChange = callbackReference,
        label = { Text(text) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    CharacterMakerTheme {
        EditTextReference("Reference", "") {}
    }
}