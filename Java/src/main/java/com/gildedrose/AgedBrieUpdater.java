package com.gildedrose;

public class AgedBrieUpdater extends ItemUpdater{

    private static AgedBrieUpdater instance;

    private AgedBrieUpdater(Item item){
        super(item);
    }

    public static AgedBrieUpdater getInstance(Item item){
       if (instance == null){
           instance = new AgedBrieUpdater(item);
       }
       return instance;
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
