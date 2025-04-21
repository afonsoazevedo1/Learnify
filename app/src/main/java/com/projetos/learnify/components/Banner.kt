package com.projetos.learnify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.projetos.learnify.R

@Preview(showBackground = true, widthDp = 360, heightDp = 300)
@Composable

fun BannerPreview() {
    Banner()
}

@Composable
fun Banner() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .height(250.dp)
    ) {
        val (img, text, promoText, button) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.card),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .constrainAs(img) {
                    linkTo(parent.top, parent.bottom)
                    linkTo(parent.start, parent.end)
                },
            contentScale = ContentScale.Crop
        )


        Text(
            text = "Curso de Massagem \n Profissional",

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold,

            color = Color.White,

            modifier = Modifier
                .padding(start = 16.dp, top = 36.dp)
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "Curso de Massagem em promoção",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .constrainAs(promoText) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                }
        )

        var isClicked by remember { mutableStateOf(false) }
        Text(
            text = "Matricular ➡️",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (isClicked) Color.White else Color(0xFF521C98),
            modifier = Modifier
                .padding(start = 24.dp, top = 16.dp)
                .constrainAs(button) {
                    top.linkTo(promoText.bottom)
                    bottom.linkTo(parent.bottom)
                }.background(
                    color = if (isClicked) Color(0xFF521C98) else Color(0xFFF0E9FA),
                    shape = RoundedCornerShape(10.dp)
                ).clickable { isClicked = !isClicked }
                .padding(8.dp)
        )
    }
}