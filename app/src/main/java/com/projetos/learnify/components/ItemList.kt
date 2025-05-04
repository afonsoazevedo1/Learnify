package com.projetos.learnify.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.projetos.learnify.model.Items
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter
import com.projetos.learnify.R

// Componente principal que exibe uma lista horizontal de itens
@Composable
fun ItemList(items: List<Items>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            ItemCard(item = item)
        }
    }
}

// Componente que representa um único cartão de item
@SuppressLint("UseKtx")
@Composable
private fun ItemCard(item: Items) {
    ConstraintLayout(
        modifier = Modifier
            .height(250.dp)
            .width(250.dp)
            .shadow(3.dp, shape = RoundedCornerShape(10.dp))
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .clickable { println("Clicked on: ${item.title}") }
    ) {
        // Referências para os elementos do layout
        val (topImg, title, ownerIcon, price, score, scoreIcon, name) = createRefs()

        // Imagem principal do item (carregada via Coil)
        val painter = rememberAsyncImagePainter(model = item.picUrl.firstOrNull() ?: "")
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .constrainAs(topImg) {
                    top.linkTo(parent.top)
                },
            contentScale = ContentScale.Crop
        )

        // Título do item
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .background(Color("#90000000".toColorInt()))
                .fillMaxWidth()
                .padding(6.dp)
                .constrainAs(title) {
                    bottom.linkTo(topImg.bottom)
                }
        )

        // Ícone de perfil (logo ou imagem de usuário)
        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = null,
            modifier = Modifier
                .size(34.dp)
                .constrainAs(ownerIcon) {
                    start.linkTo(parent.start)
                    top.linkTo(title.bottom)
                }
                .padding(start = 16.dp, top = 16.dp)
        )

        Text(
            text = item.name,
            modifier = Modifier
                .constrainAs(name) {
                    start.linkTo(ownerIcon.end)
                    top.linkTo(ownerIcon.top)
                    bottom.linkTo(ownerIcon.bottom)
                }
                .padding(start = 16.dp, top = 16.dp)
        )

        // Preço do item
        Text(
            text = "R$ ${item.price}",
            fontWeight = FontWeight.Bold,
            color = Color("#521c98".toColorInt()),
            modifier = Modifier
                .constrainAs(price) {
                    start.linkTo(parent.start)
                    top.linkTo(ownerIcon.bottom)
                }
                .padding(start = 16.dp, top = 8.dp)
        )

        // Pontuação do item
        Text(
            text = item.score.toString(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(score) {
                    end.linkTo(parent.end)
                    top.linkTo(price.top)
                }
                .padding(end = 16.dp)
        )

        // Ícone de estrela ao lado da pontuação
        Image(
            painter = painterResource(id = R.drawable.star),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(scoreIcon) {
                    end.linkTo(score.start)
                    top.linkTo(score.top)
                }
                .padding(end = 8.dp)
        )
    }
}

/// Pré-visualização do componente ItemList
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewItemList() {
    val sampleItems = listOf(
        Items(
            title = "Produto 1",
            price = 199.99,
            score = 4.5,
            picUrl = listOf("image")
        ),
        Items(
            title = "Produto 2",
            price = 299.99,
            score = 3.8,
            picUrl = listOf("image")
        )
    )
    ItemList(items = sampleItems)
}