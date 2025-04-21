package com.projetos.learnify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projetos.learnify.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Categories() {

    val categories = listOf(
        Category("Negócios", R.drawable.cat1),
        Category("Artes", R.drawable.cat2),
        Category("Meditação", R.drawable.cat3),
        Category("Outros", R.drawable.cat4)
    )
    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    Column(modifier = Modifier.padding(top = 24.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categoria",
                color = Color(0xFF521C98),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Veja todos",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF521C98),
                fontSize = 16.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            categories.forEach { category ->
                CategoryItem(
                    icon = category.icon,
                    label = category.label,
                    isSelected = selectedCategory == category,
                    onClick = { selectedCategory = category }
                )
            }
        }
    }
}

@Composable
private fun CategoryItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = if (isSelected) Color(0xFFD1C4E9) else Color(0xFFF0E9FA),
                    shape = RoundedCornerShape(10.dp)                )
                .padding(4.dp)
        )
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF521C98)
        )
    }
}

// Classe auxiliar para representar as categorias
data class Category(
    val label: String,
    val icon: Int,
)