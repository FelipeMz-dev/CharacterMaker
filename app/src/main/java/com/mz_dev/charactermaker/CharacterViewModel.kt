package com.mz_dev.charactermaker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.image.ImageCreation
import com.aallam.openai.api.image.ImageSize
import com.aallam.openai.api.logging.LogLevel
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.LoggingConfig
import com.aallam.openai.client.OpenAI
import com.mz_dev.charactermaker.conf.ConfStrings
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    var isLoading: Boolean by mutableStateOf(false)
    var nameCharacter: String by mutableStateOf("")
    var urlImage: String by mutableStateOf("")

    private var openAI = OpenAI(token = ConfStrings.KEY_OPENAI, logging = LoggingConfig(LogLevel.All))

    fun generateCharacter(references: Character){
        isLoading = true
        generateName(references)
        generateImage(references)
    }

    @OptIn(BetaOpenAI::class)
    private fun generateImage(references: Character) = viewModelScope.launch {
        var prompt = "one character, ${references.toList()}"
        var images = openAI.imageURL(creation = ImageCreation(prompt, n = 1, size = ImageSize.is512x512))
        urlImage = images.first().url
    }

    @OptIn(BetaOpenAI::class)
    private fun generateName(references: Character) = viewModelScope.launch {
        val textCharacter = "create a name for a character with the following features: ${references.toList()}"
        val chatCompletionRequest = ChatCompletionRequest(
            model = ModelId(ConfStrings.GPT_MODEL),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.User,
                    content = textCharacter
                )
            )
        )
        nameCharacter = openAI.chatCompletion(chatCompletionRequest).choices.first().message?.content.toString()
    }
}