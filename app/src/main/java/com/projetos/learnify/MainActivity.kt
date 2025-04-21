package com.projetos.learnify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.projetos.learnify.screens.HomeScreen
import com.projetos.learnify.ui.theme.LearnifyTheme
import com.projetos.learnify.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnifyTheme {
                val viewModel: HomeViewModel = viewModel()
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}