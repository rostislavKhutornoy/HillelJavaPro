package ua.ithillel.hw9.service;

import ua.ithillel.hw9.entity.Bouquet;
import ua.ithillel.hw9.util.ArraysUtil;

public class FlowersShop {
    private Bouquet[] bouquets;

    public FlowersShop() {
        this.bouquets = new Bouquet[0];
    }

    public void addBouquet(Bouquet bouquet) {
        bouquets = ArraysUtil.extendBouquetArray(bouquets, bouquet);
    }

    @Override
    public String toString() {
        String result = "";
        for (Bouquet bouquet : bouquets) {
            result += bouquet.toString() + '\n';
        }
        return result;
    }

    public Bouquet[] getBouquets() {
        return bouquets;
    }

    public void setBouquets(Bouquet[] bouquets) {
        this.bouquets = bouquets;
    }
}
