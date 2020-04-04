package com.andreev.funtest.main_screen.adapter

import com.andreev.funtest.main_screen.models.DeadCell
import com.andreev.funtest.main_screen.models.Life
import com.andreev.funtest.main_screen.models.LivingCell
import com.andreev.funtest.main_screen.models.WorldItem

enum class Combination {
    THREE_DIED,
    THREE_LIVING
}

fun ArrayList<WorldItem>.checkCombinations(): Combination? {

    if (this.size >= 3) {
        var isDeadCells = true
        var isLivingCells = true
        for (index in this.lastIndex - 2 .. this.lastIndex) {
            val item = this[index]
            isDeadCells = isDeadCells && (item is DeadCell)
            isLivingCells = isLivingCells && (item is LivingCell)
        }
        if (isDeadCells) {
            return Combination.THREE_DIED
        }
        else if (isLivingCells) {
            return Combination.THREE_LIVING
        }
    }

    return null
}

fun ArrayList<WorldItem>.getLifeIndexForRemove(): Int {
    if (this.size > 3) {
        val index = this.lastIndex - 3
        if (index >= 0) {
            if (this[index] is Life) {
                return index
            }
        }
    }
    return -1
}