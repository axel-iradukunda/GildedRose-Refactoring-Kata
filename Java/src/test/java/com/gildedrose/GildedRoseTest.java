package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    // Test the behavior of a regular item
    @Test
    void testRegularItem() {
        Item[] items = new Item[] { new Item(DEXTERITY_VEST, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    // Test the behavior of "Aged Brie" which increases in quality as it ages
    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    // Test the behavior of "Sulfuras" which never decreases in quality or needs to be sold
    @Test
    void testSulfuras() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    // Test the behavior of "Backstage passes" which increase in quality as the concert date approaches
    @Test
    void testBackstagePasses() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    // Test the behavior of "Backstage passes" when there are 10 days or less until the concert
    @Test
    void testBackstagePassesWith10DaysOrLess() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    // Test the behavior of "Backstage passes" when there are 5 days or less until the concert
    @Test
    void testBackstagePassesWith5DaysOrLess() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    // Test the behavior of "Backstage passes" after the concert date has passed
    @Test
    void testBackstagePassesAfterConcert() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // Test the behavior of "Conjured" items which degrade in quality twice as fast as normal items
    @Test
    void testConjuredItem() {
        Item[] items = new Item[] { new Item(CONJURED_MANA_CAKE, 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    // Test the behavior of "Conjured" items after the sell-by date has passed
    @Test
    void testConjuredItemAfterSellIn() {
        Item[] items = new Item[] { new Item(CONJURED_MANA_CAKE, 0, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
}
