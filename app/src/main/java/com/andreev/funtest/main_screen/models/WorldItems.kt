package com.andreev.funtest.main_screen.models

interface WorldItem {
    fun getItemImage(): Int
    fun getItemName(): Int
    fun getItemDescription(): Int
}

open class ListItem : WorldItem {
    protected val image: Int
    protected val name: Int
    protected val description: Int

    constructor(image: Int, name: Int, description: Int) {
        this.image = image
        this.name = name
        this.description = description
    }

    override fun getItemImage(): Int = image
    override fun getItemName(): Int = name
    override fun getItemDescription(): Int = description
}