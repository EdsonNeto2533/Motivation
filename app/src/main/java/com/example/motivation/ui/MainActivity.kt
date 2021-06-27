package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.PreferenciasSegurança
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mPreferenciasSegurança: PreferenciasSegurança
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mPreferenciasSegurança = PreferenciasSegurança(this)
        //seta o nome salvo antes no textView
        tvHello.text = " olá, ${mPreferenciasSegurança.getString(MotivationConstants.key.nome_pessoa)}"

    }
}