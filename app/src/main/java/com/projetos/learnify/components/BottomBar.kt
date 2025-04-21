package com.projetos.learnify.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projetos.learnify.R


data class BottomMenuItem(
    val label: String,
    val icon: Painter,
)

@Preview(showBackground = true, widthDp = 360, heightDp = 150)
@Composable
fun BottomBarPreview() {
    BottomBar()
}

@Composable
fun BottomBar() {
    val bottomMenuItems = listOf(
        BottomMenuItem("Explorar", painterResource(id = R.drawable.btn_1)),
        BottomMenuItem("Lista", painterResource(id = R.drawable.btn_2)),
        BottomMenuItem("Cursos", painterResource(id = R.drawable.btn_3)),
        BottomMenuItem("Conta", painterResource(id = R.drawable.btn_4))
    )

    var selectedItem by remember { mutableStateOf("Explorar") }
    BottomAppBar(
        backgroundColor = Color(android.graphics.Color.parseColor("#f8f8f8")),
        elevation = 3.dp,
        modifier = Modifier.height(80.dp)
    ) {
        bottomMenuItems.forEach { item ->
            BottomNavigationItem(
                selected = selectedItem == item.label,
                onClick = { selectedItem = item.label },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(bottom = 8.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            )
        }
    }
}