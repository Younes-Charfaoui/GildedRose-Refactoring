package org.youtube


data class Item(val name: String, val sellInDays: Int, val quality: Int) {
    override fun toString() = "$name, $sellInDays, $quality"
}

sealed class ItemCategory(open val name: String) {

    abstract fun updateAmount(item: Item) : Int

    data object AgedBrie : ItemCategory("Aged Brie") {
        override fun updateAmount(item: Item) = if (item.sellInDays < 0) 2 else 1
    }

    data object Sulfuras : ItemCategory("Sulfuras, Hand of Ragnaros") {
        override fun updateAmount(item: Item) = 0
    }

    data object Backstage : ItemCategory("Backstage passes to a TAFKAL80ETC concert") {
        override fun updateAmount(item: Item) = when {
            item.sellInDays < 0 -> -item.quality
            item.sellInDays < 5 -> 3
            item.sellInDays < 10 -> 2
            else -> 1
        }
    }

    data object Conjured : ItemCategory("Conjured Mana Cake") {
        override fun updateAmount(item: Item) = -2
    }

    data class Other(override val name: String) : ItemCategory(name) {
        override fun updateAmount(item: Item) = if (item.sellInDays < 0) -2 else -1
    }
}

val Item.category: ItemCategory
    get() {
        return when (name) {
            "Aged Brie" -> ItemCategory.AgedBrie
            "Sulfuras, Hand of Ragnaros" -> ItemCategory.Sulfuras
            "Backstage passes to a TAFKAL80ETC concert" -> ItemCategory.Backstage
            "Conjured Mana Cake" -> ItemCategory.Conjured
            else -> ItemCategory.Other(name)
        }
    }