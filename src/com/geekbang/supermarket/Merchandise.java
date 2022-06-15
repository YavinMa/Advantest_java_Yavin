package com.geekbang.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;
    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。赠品是" + gift.name + "。价值" + gift.purchasePrice);
    }

    public double calculateProfit(){
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;

    }


    public double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }

        System.out.println("商品单价为" + purchasePrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount * purchasePrice / 2;

        count -= countToBuy;

        return totalCost;
    }

    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }

        System.out.println("商品单价为" + purchasePrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount * purchasePrice / 2;

        count -= countToBuy;

        if (printLeft) {
            System.out.println("商品剩余库存为：" + printLeft);
        }

        return totalCost;
    }


    public boolean totalValueBiggerThan(Merchandise merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }


    public boolean isTheBiggestTotalValueOne(Supermarket supermarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < supermarket.merchandises.length; i++) {
            Merchandise m = supermarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {

                return false;
            }
        }
        return true;
    }

    public Merchandise gift;

    public double getSoldPrice() {
        return soldPrice;
    }

    public String getName() {
        return name;
    }

    public Merchandise getGiftAndHowCanOutsideChangeIt() {
        return gift;
    }


    public void willOutsideValueChangeIfParameterValueChangeHereRef(Merchandise m2) {
        m2 = gift;
    }

    public void willOutsideValueChangeIfParameterValueChangeHerePrime(int intVal) {
        intVal = 99999999;
    }

    public void changeToTheSameGift(Merchandise m2) {
        m2.gift = gift;
    }

}
