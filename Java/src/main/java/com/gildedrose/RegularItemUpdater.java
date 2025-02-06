package com.gildedrose;

public class RegularItemUpdater extends ItemUpdater{
    private static RegularItemUpdater instance;

    private RegularItemUpdater(Item item){
        super(item);
    }

    public static RegularItemUpdater getInstance(Item item){
        if(instance == null){
            instance = new RegularItemUpdater(item);
        }
        return instance;
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
