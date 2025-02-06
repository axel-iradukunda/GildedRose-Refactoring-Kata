package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater{

    private static BackstagePassesUpdater instance;

    private BackstagePassesUpdater(Item item){
        super(item);
    }

    public static BackstagePassesUpdater getInstance(Item item){
        if(instance == null){
            instance = new BackstagePassesUpdater(item);
        }
        return instance;
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
