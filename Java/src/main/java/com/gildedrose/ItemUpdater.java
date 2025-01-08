package com.gildedrose;

abstract class ItemUpdater {
    protected Item item;

    public ItemUpdater(Item item){
        this.item = item;
    }

    public abstract void updateQuality();

    public void updateSellIn() {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }

    public void handleExpired() {
        if (item.sellIn < 0) {
            updateExpiredQuality();
        }
    }

    protected abstract void updateExpiredQuality();
}
