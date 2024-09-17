package org.youtube

class GildedRoseUpdater(var items: List<Item>) {
    fun updateQuality() {
        items = items.map(Item::updateItem)
    }
}

private fun Item.updateItem() = updateSellInDays().updateQuality()

private fun Item.updateSellInDays()  =
    copy(sellInDays = sellInDays - if (category == ItemCategory.Sulfuras) 0 else 1)

private fun Item.updateQuality(): Item {
    if (category == ItemCategory.Sulfuras) return copy()
    return copy(quality = (quality + category.updateAmount(this)).coerceIn(0, 50))
}