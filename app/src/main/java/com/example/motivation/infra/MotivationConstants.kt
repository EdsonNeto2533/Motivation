package com.example.motivation.infra

//private constructor evita a classe de ser instanciada
class MotivationConstants private constructor() {
    //object para ser acessado
    object key {
         val nomePessoa = "nome"
    }

    object filtroFrase {
        val feliz = 1
        val bomDia = 2
        val todos = 3
    }

}