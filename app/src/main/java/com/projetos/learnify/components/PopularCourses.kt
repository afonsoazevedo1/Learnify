package com.projetos.learnify.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Componente que exibe o cabeçalho "Cursos Populares"
@Composable
fun PopularCourses() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Cursos Populares",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Veja Todos",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}

// Pré-visualização do componente PopularCourses
@Preview(showBackground = true, showSystemUi = true) // Habilita a pré-visualização no modo split
@Composable
fun PopularCoursesPreview() {
    PopularCourses()
}