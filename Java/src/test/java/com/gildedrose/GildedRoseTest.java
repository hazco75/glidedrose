package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // REGULAR ITEM

    @Test
    void updateRegularItem_ShouldDecreaseQualityByOne() {
        Item[] items = new Item[]{new Item("foo", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(29, app.items[0].quality);
    }

    @Test
    void updateRegularItem_SellInBelowZero_ShouldDecreaseQualityByTwo() {
        Item[] items = new Item[]{new Item("foo", -1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void updateRegularItem_QualityEqualsToZero_ShouldRemainQualityToZero() {
        Item[] items = new Item[]{new Item("foo", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateRegularItem_QualityEqualsToZeroSellInBelowZero_ShouldRemainQualityToZero() {
        Item[] items = new Item[]{new Item("foo", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // AGED BRIE ITEM

    @Test
    void updateAgedBrieItemQuality_ShouldIncreaseQualityByOne() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void updateAgedBrieItemQuality_QualityEqualsToFifty_ShouldRemainQualityAtFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    // BACKSTAGE ITEM

    @Test
    void updateBackstageItemQuality_ShouldIncreaseQualityByOne() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateBackstageItem_SellInTenOrLess_ShouldIncreaseQualityByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateBackstageItem_SellInFiveOrLess_ShouldIncreaseQualityByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateBackstageItem_SellInZero_ShouldDecreaseQualityToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // SULFURA ITEM

    @Test
    void updateSulfuraItem_ShouldPutQualityToEighty() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    // CONJURED ITEM

    @Test
    void updateConjuredItem_ShouldDecreaseQualityByTwo() {
        Item[] items = new Item[]{new Item("Conjured", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void updateConjuredItem_SellInBelowZero_ShouldDecreaseQualityByFour() {
        Item[] items = new Item[]{new Item("Conjured", -1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }
}
