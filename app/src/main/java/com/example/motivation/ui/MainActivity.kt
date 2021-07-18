package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.PreferenciasSegurança
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mPreferenciasSegurança: PreferenciasSegurança
    //garantir que no inicio da activity ja venha algo no filtro
    private var filtro: Int = MotivationConstants.filtroFrase.todos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideToolbar()
        //logica inicial para ja vir uma frase
        imgTodas.setColorFilter(resources.getColor(R.color.rosa))
        novaFrase()

        mPreferenciasSegurança = PreferenciasSegurança(this)
        //seta o nome salvo antes no textView
        tvHello.text = " olá, ${mPreferenciasSegurança.getString(MotivationConstants.key.nomePessoa)}"


        //eventos de click + deixa botao selecionado de outra cor
        imgTodas.setOnClickListener {
            novoFiltro(MotivationConstants.filtroFrase.todos)
        }
        imgBomDia.setOnClickListener {
            novoFiltro(MotivationConstants.filtroFrase.bomDia)
        }
        imgFeliz.setOnClickListener {
            novoFiltro(MotivationConstants.filtroFrase.feliz)
        }
        btnNovaFrase.setOnClickListener {
            novaFrase()
        }

    }

    private fun novoFiltro(id: Int) {
        //garante q sempre que clicar em algum outro botao vai ficar branco
        imgFeliz.setColorFilter(resources.getColor(R.color.white))
        imgBomDia.setColorFilter(resources.getColor(R.color.white))
        imgTodas.setColorFilter(resources.getColor(R.color.white))


        when (id) {
            1 -> {
                imgFeliz.setColorFilter(resources.getColor(R.color.rosa))
                filtro = MotivationConstants.filtroFrase.feliz
            }
            2 -> {
                imgBomDia.setColorFilter(resources.getColor(R.color.rosa))
                filtro = MotivationConstants.filtroFrase.bomDia
            }
            3 -> {
                imgTodas.setColorFilter(resources.getColor(R.color.rosa))
                filtro = MotivationConstants.filtroFrase.todos
            }

        }
    }

    private fun novaFrase() {
      tvFrase.text =  Mock().getFrase(filtro)
    }

    private fun hideToolbar() {
        //esconde toolbar, o suporteActionBar!! garante a execução pois o kotlin espera nullPointerExecption
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

}