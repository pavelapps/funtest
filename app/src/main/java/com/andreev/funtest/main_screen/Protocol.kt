package com.andreev.funtest.main_screen

import com.andreev.funtest.main_screen.models.WorldItem

interface Protocol {
    interface View {
        fun addCell(cell: WorldItem)
    }

    interface Presenter {
        fun onGenerateButtonClick()
    }
}