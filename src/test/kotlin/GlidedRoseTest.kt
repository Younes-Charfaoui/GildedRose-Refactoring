import org.junit.jupiter.api.Test
import org.youtube.GildedRoseUpdater
import org.youtube.Item
import kotlin.test.assertEquals

class GlidedRoseTest {

    val expected = """
        OMGHAI!
        -------- day 0 --------
        name, sellIn, quality
        +5 Dexterity Vest, 10, 20
        Aged Brie, 2, 0
        Elixir of the Mongoose, 5, 7
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 15, 20
        Backstage passes to a TAFKAL80ETC concert, 10, 49
        Backstage passes to a TAFKAL80ETC concert, 5, 49
        Conjured Mana Cake, 3, 6

        -------- day 1 --------
        name, sellIn, quality
        +5 Dexterity Vest, 9, 19
        Aged Brie, 1, 1
        Elixir of the Mongoose, 4, 6
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 14, 21
        Backstage passes to a TAFKAL80ETC concert, 9, 50
        Backstage passes to a TAFKAL80ETC concert, 4, 50
        Conjured Mana Cake, 2, 4

        -------- day 2 --------
        name, sellIn, quality
        +5 Dexterity Vest, 8, 18
        Aged Brie, 0, 2
        Elixir of the Mongoose, 3, 5
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 13, 22
        Backstage passes to a TAFKAL80ETC concert, 8, 50
        Backstage passes to a TAFKAL80ETC concert, 3, 50
        Conjured Mana Cake, 1, 2

        -------- day 3 --------
        name, sellIn, quality
        +5 Dexterity Vest, 7, 17
        Aged Brie, -1, 4
        Elixir of the Mongoose, 2, 4
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 12, 23
        Backstage passes to a TAFKAL80ETC concert, 7, 50
        Backstage passes to a TAFKAL80ETC concert, 2, 50
        Conjured Mana Cake, 0, 0

        -------- day 4 --------
        name, sellIn, quality
        +5 Dexterity Vest, 6, 16
        Aged Brie, -2, 6
        Elixir of the Mongoose, 1, 3
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 11, 24
        Backstage passes to a TAFKAL80ETC concert, 6, 50
        Backstage passes to a TAFKAL80ETC concert, 1, 50
        Conjured Mana Cake, -1, 0

        -------- day 5 --------
        name, sellIn, quality
        +5 Dexterity Vest, 5, 15
        Aged Brie, -3, 8
        Elixir of the Mongoose, 0, 2
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 10, 25
        Backstage passes to a TAFKAL80ETC concert, 5, 50
        Backstage passes to a TAFKAL80ETC concert, 0, 50
        Conjured Mana Cake, -2, 0

        -------- day 6 --------
        name, sellIn, quality
        +5 Dexterity Vest, 4, 14
        Aged Brie, -4, 10
        Elixir of the Mongoose, -1, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 9, 27
        Backstage passes to a TAFKAL80ETC concert, 4, 50
        Backstage passes to a TAFKAL80ETC concert, -1, 0
        Conjured Mana Cake, -3, 0


    """.trimIndent()

    @Test
    fun test7Days() {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("OMGHAI!")

        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Conjured Mana Cake", 3, 6)
        )

        val app = GildedRoseUpdater(items)

        var days = 7

        for (i in 0..days - 1) {
            stringBuilder.appendLine("-------- day $i --------")
            stringBuilder.appendLine("name, sellIn, quality")
            for (item in app.items) {
                stringBuilder.appendLine(item)
            }
            stringBuilder.appendLine()
            app.updateQuality()
        }

        assertEquals(
            expected,
            stringBuilder.toString()
        )
    }
}