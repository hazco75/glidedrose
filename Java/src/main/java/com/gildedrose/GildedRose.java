package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    final int QUALITY_LIMIT = 50;
    final int SULFURA_QUALITY = 80;
    final int BACKSTAGE_QUALITY_FIRST_THRESHOLD = 11;
    final int BACKSTAGE_QUALITY_SECOND_THRESHOLD = 6;

    final String AGED_BRIE_ITEM_NAME = "Aged Brie";
    final String BACKSTAGE_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    final String SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    final String CONJURED_ITEM = "Conjured";

    Item[] items;
    List<String> increasingQualityItems = Arrays.asList(AGED_BRIE_ITEM_NAME, BACKSTAGE_ITEM_NAME);


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS_ITEM_NAME) && item.quality != SULFURA_QUALITY) {
                item.quality = SULFURA_QUALITY;
            } else {
                handleRegularQualityModification(item);
                handleQualityModificationBySellIn(item);
            }

        }
    }

    public boolean isIncreasingQualityItem(String itemName) {
        return increasingQualityItems.contains(itemName);
    }

    public void handleRegularQualityModification(Item item) {
        if (!isIncreasingQualityItem(item.name)) {
            if (item.quality > 0) {
                item.quality -= item.name.equals(CONJURED_ITEM) ? 2 : 1;
            }
        } else {
            if (item.quality < QUALITY_LIMIT) {
                item.quality++;

                if (item.name.equals(BACKSTAGE_ITEM_NAME)) {
                    if (item.sellIn < BACKSTAGE_QUALITY_FIRST_THRESHOLD) {
                        if (item.quality < QUALITY_LIMIT) {
                            item.quality++;
                        }
                    }
                    if (item.sellIn < BACKSTAGE_QUALITY_SECOND_THRESHOLD) {
                        if (item.quality < QUALITY_LIMIT) {
                            item.quality++;
                        }
                    }
                }
            }
        }
    }

    public void handleQualityModificationBySellIn(Item item) {

        item.sellIn -= 1;

        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE_ITEM_NAME)) {
                if (!item.name.equals(BACKSTAGE_ITEM_NAME)) {
                    if (item.quality > 0) {
                        item.quality -= item.name.equals(CONJURED_ITEM) ? 2 : 1;
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < QUALITY_LIMIT) {
                    item.quality++;
                }
            }
        }
    }

}
