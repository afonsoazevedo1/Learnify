package com.projetos.learnify.model

data class Items(
    val title: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val score: Double = 0.0,
    val picUrl: List<String> = emptyList()
) {
    // Construtor sem argumentos
    constructor() : this("", "", 0.0, 0.0, emptyList())
}
