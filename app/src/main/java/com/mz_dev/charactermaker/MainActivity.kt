package com.mz_dev.charactermaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mz_dev.charactermaker.ui.theme.CharacterMakerTheme
import com.mz_dev.charactermaker.ui.contents.ContentEditReferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterMakerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val scrollState = rememberScrollState()
    val viewModel = CharacterViewModel()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    "Character Maker",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(padding)
                .alpha(if (viewModel.isLoading) 0.5f else 1f)
        ) {
            ContentEditReferences(viewModel)
            if (viewModel.nameCharacter.isNotEmpty() && viewModel.urlImage.isNotEmpty()) {
                val name = viewModel.nameCharacter
                val url = viewModel.urlImage
                Text("Name: $name", modifier = Modifier.padding(10.dp))
                AsyncImage(
                    model = url,
                    contentDescription = "AI response",
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                )
                viewModel.isLoading = false
            }
        }
        if (viewModel.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    CharacterMakerTheme {
        MainContent()
    }
}