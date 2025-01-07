package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateItemSellIn(item);
            handleExpiredItem(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            updateSpecialItemQuality(item);
        } else {
            decreaseQuality(item);
            if (isConjured(item)) {
                decreaseQuality(item); // Conjured items degrade twice as fast
            }
        }
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                increaseQuality(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                item.quality = 0;
            } else {
                decreaseQuality(item);
                if (isConjured(item)) {
                    decreaseQuality(item); // Conjured items degrade twice as fast
                }
            }
        }
    }

    private void updateSpecialItemQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED);
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            item.quality--;
        }
    }
}
