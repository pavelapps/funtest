package com.andreev.funtest.main_screen.data

import com.andreev.funtest.main_screen.models.DeadCell
import com.andreev.funtest.main_screen.models.LivingCell
import com.andreev.funtest.main_screen.models.WorldItem

interface Generator {
    fun generateRandomCell(): WorldItem
}

enum class GeneratedCell {
    LIVING,
    DIED
}

open class WorldGenerator : Generator {

    private val allValues = GeneratedCell.values()
    private val lastIndex = allValues.lastIndex

    override fun generateRandomCell(): WorldItem {
        val randomIndex = (0 .. lastIndex).random()
        return convertToWorldItem(allValues[randomIndex])
    }

    protected fun convertToWorldItem(cell: GeneratedCell) = when(cell) {
        GeneratedCell.DIED -> DeadCell()
        GeneratedCell.LIVING -> LivingCell()
    }
}

class TestGenerator : WorldGenerator() {

    private var currentIndex = -1
    private val testArray = arrayListOf<GeneratedCell>(
        GeneratedCell.LIVING,
        GeneratedCell.LIVING,
        GeneratedCell.LIVING,
        GeneratedCell.DIED,
        GeneratedCell.DIED,
        GeneratedCell.DIED
    )

    override fun generateRandomCell(): WorldItem {
        if (++currentIndex > testArray.lastIndex)
            currentIndex = 0
        return convertToWorldItem(testArray[currentIndex])
    }
}