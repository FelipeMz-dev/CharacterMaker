package com.mz_dev.charactermaker.ui.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mz_dev.charactermaker.Character
import com.mz_dev.charactermaker.CharacterViewModel
import com.mz_dev.charactermaker.ui.components.ButtonSubmitReferences
import com.mz_dev.charactermaker.ui.components.EditTextReference
import com.mz_dev.charactermaker.ui.components.TextHead
import com.mz_dev.charactermaker.ui.theme.CharacterMakerTheme

@Composable
fun ContentEditReferences(viewModel: CharacterViewModel) {

    var head by remember { mutableStateOf("") }
    var torso by remember { mutableStateOf("") }
    var limbs by remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        TextHead("Fill the references:")
        EditTextReference("Head", head) { head = it }
        EditTextReference("Torso", torso) { torso = it }
        EditTextReference("Limbs", limbs) { limbs = it }
        ButtonSubmitReferences("Make it") {
            if (viewModel.nameCharacter.isNotEmpty() && viewModel.urlImage.isNotEmpty()){
                viewModel.nameCharacter = ""
                viewModel.urlImage = ""
            }
            if (
                head.isNotEmpty() ||
                torso.isNotEmpty() ||
                limbs.isNotEmpty()
            ) {
                viewModel.generateCharacter(
                    Character(
                        head, torso, limbs
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    CharacterMakerTheme {
        ContentEditReferences(CharacterViewModel())
    }
}