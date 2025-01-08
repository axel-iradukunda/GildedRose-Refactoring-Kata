package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater{
    public ConjuredItemUpdater(Item item){
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }

    @Override
    protected void updateExpiredQuality() {
        decreaseQuality();
        decreaseQuality();
    }

}
