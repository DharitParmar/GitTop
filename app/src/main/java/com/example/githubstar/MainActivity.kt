package com.example.githubstar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.*
import com.example.githubstar.core.ui.theme.GithubStarTheme
import com.example.githubstar.feature.search.presentation.*
import dagger.hilt.android.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    GithubStarTheme {
                        // A surface container using the 'background' color from the theme
                        SearchScreen(viewModel())
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubStarTheme {
        SearchScreen()
    }
}