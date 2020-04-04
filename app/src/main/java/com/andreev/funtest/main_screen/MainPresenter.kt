package com.andreev.funtest.main_screen

import com.andreev.funtest.main_screen.data.Generator
import com.andreev.funtest.main_screen.data.WorldGenerator

class MainPresenter(private val view: Protocol.View) : Protocol.Presenter {

    private var generator: Generator = WorldGenerator() //TestGenerator()

    override fun onGenerateButtonClick() {
        val newItem = generator.generateRandomCell()
        view.addCell(newItem)
    }
}