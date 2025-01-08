package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater{
    public BackstagePassesUpdater(Item item){
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void updateExpiredQuality() {
        item.quality = 0;
    }


}
