package com.example.motivation.repository

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

data class frase(val desc: String, val categoria: Int)

class Mock {
    private val todos = MotivationConstants.filtroFrase.todos
    private val feliz  = MotivationConstants.filtroFrase.feliz
    private val bomDia = MotivationConstants.filtroFrase.bomDia




    private val mListaFrases: List<frase> = listOf(
            frase("Não sabendo que era impossível, foi lá e fez.", feliz),
            frase("Você não é derrotado quando perde, você é derrotado quando desiste!", feliz),
            frase("Quando está mais escuro, vemos mais estrelas!", feliz),
            frase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", feliz),
            frase("Não pare quando estiver cansado, pare quando tiver terminado.", feliz),
            frase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", feliz),
            frase("A melhor maneira de prever o futuro é inventá-lo.", bomDia),
            frase("Você perde todas as chances que você não aproveita.", bomDia),
            frase("Fracasso é o condimento que dá sabor ao sucesso.", bomDia),
            frase(" Enquanto não estivermos comprometidos, haverá hesitação!", bomDia),
            frase("Se você não sabe onde quer ir, qualquer caminho serve.", bomDia),
            frase("Se você acredita, faz toda a diferença.", bomDia),
            frase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", bomDia)
    )

    fun getFrase(categoriaID: Int): String{
        //realiza o filtro || = ou
        val filtragem = mListaFrases.filter { (it.categoria == categoriaID) || (categoriaID == todos) }
        //pega um numero randomico dentro da lista
        val randomico = Random.nextInt(filtragem.size)
        return filtragem[randomico].desc
    }
}