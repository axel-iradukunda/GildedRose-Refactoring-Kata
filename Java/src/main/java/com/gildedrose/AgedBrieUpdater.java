package com.gildedrose;

public class AgedBrieUpdater extends ItemUpdater{
    public AgedBrieUpdater(Item item){
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void updateExpiredQuality() {
        increaseQuality();
    }

}
