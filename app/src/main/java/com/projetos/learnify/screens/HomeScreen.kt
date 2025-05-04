package com.projetos.learnify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.projetos.learnify.components.Banner
import com.projetos.learnify.components.BottomBar
import com.projetos.learnify.components.Categories
import com.projetos.learnify.components.ItemList
import com.projetos.learnify.components.PopularCourses
import com.projetos.learnify.components.SearchRow
import com.projetos.learnify.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val popularCourses = viewModel.popularCourses.observeAsState(emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            SearchRow()
            Banner()
            Categories()
            PopularCourses()
            ItemList(items = popularCourses.value)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val viewModel = HomeViewModel()
    HomeScreen(viewModel = viewModel)
}