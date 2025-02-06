package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater{

    private static ConjuredItemUpdater instance;


    private ConjuredItemUpdater(Item item){
        super(item);
    }

    public static ConjuredItemUpdater getInstance(Item item){
        if(instance == null){
            instance = new ConjuredItemUpdater(item);
        }
        return instance;
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
