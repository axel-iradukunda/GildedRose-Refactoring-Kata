package com.gildedrose;

public class RegularItemUpdater extends ItemUpdater{
    public RegularItemUpdater(Item item){
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
    }

    @Override
    protected void updateExpiredQuality() {
        decreaseQuality();
    }
}
