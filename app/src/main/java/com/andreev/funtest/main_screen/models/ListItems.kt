package com.andreev.funtest.main_screen.models

import com.andreev.funtest.R

class DeadCell : ListItem(
    R.drawable.cell_dead,
    R.string.name_cell_dead,
    R.string.description_cell_dead
)

class LivingCell : ListItem(
    R.drawable.cell_living,
    R.string.name_cell_living,
    R.string.description_cell_living
)

class Life : ListItem(
    R.drawable.life,
    R.string.name_life,
    R.string.description_life
)