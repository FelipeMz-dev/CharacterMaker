package com.mz_dev.charactermaker.ui.components

import android.graphics.drawable.Icon
import android.print.PrintAttributes.Margins
import android.view.ViewGroup.MarginLayoutParams
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mz_dev.charactermaker.ui.theme.CharacterMakerTheme

@Composable
fun ButtonSubmitReferences(text: String, callbackSubmit: () -> Unit) {
    Button(
        onClick = callbackSubmit,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Icon(
            Icons.Default.Build,
            "make icon",
            Modifier.size(24.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text.uppercase(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    CharacterMakerTheme {
        ButtonSubmitReferences("Text Button") {

        }
    }
}