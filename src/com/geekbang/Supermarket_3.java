package com.geekbang;

import com.geekbang.supermarket.Supermarket;
import com.geekbang.supermarket.Merchandise;
public class Supermarket_3 {
    public static void main(String[] args) {
        // 创建一个小超市类
        Supermarket supermarket = new Supermarket();
        // 依次给超市的名字，地址，停车位赋值
        supermarket.supermkName = "有家小超市";
        supermarket.address = "浦东大道520号";
        supermarket.parkingCount = 100;
        // 给超市200种商品
        supermarket.merchandises = new Merchandise[3];
        // 统计用的数组
        supermarket.merchandiseSold = new int[supermarket.merchandises.length];

        // 为了使用方便，创建一个商品数组引用，和supermarket.merchandises指向同一个数组对象
        Merchandise[] all = supermarket.merchandises;

        Merchandise giftNoodle = new Merchandise();
        giftNoodle.name = "赠品-面条";
        giftNoodle.count = 2000;
        giftNoodle.purchasePrice = 5;
        giftNoodle.soldPrice = 0.05;
        giftNoodle.id = "GIFT001";

        Merchandise giftBowl = new Merchandise();
        giftBowl.name = "赠品-碗";
        giftBowl.count = 2000;
        giftBowl.purchasePrice = 8;
        giftBowl.soldPrice = 0.08;
        giftBowl.id = "GIFT002";

        // 遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            // 创建并给商品的属性赋值
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = (i + 1) * 100;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            m.gift = giftNoodle;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
            m.describe();
        }

        int index = 0;

        Merchandise m = supermarket.merchandises[index];

        int c = 7;


        double totalCost = m.buy((c + 2) * 5);
        System.out.println("商品总价为：" + totalCost);

        boolean biggerThan = m.totalValueBiggerThan(supermarket.merchandises[index + 1]);
        System.out.println(biggerThan);


        Merchandise paramRef = supermarket.merchandises[2];
        int paramPrime = 7;

        System.out.println("调用前");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        m.willOutsideValueChangeIfParameterValueChangeHerePrime(paramPrime);
        // 效果类似如下代码
        // 形参实参赋值：int intVal = paramPrime;
        // 方法里执行：intVal = 99999999;
        m.willOutsideValueChangeIfParameterValueChangeHereRef(paramRef);
        // 效果类似如下代码
        // 形参实参赋值：MerchandiseV2 m2 = paramRef;
        // 方法里执行：m2 = gift;

        System.out.println("调用后");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        // ------ 返回值 -------

        double soldPrice = m.getSoldPrice();

        System.out.println(soldPrice);
        m.describe();


        System.out.println("调用getGiftAndHowCanOutsideChangeIt和getSoldPrice之前");

        m.describe();

        Merchandise giftOfM = m.getGiftAndHowCanOutsideChangeIt();

        giftOfM = giftBowl;

        double mSoldPrice = m.getSoldPrice();

        mSoldPrice = 9999999;

        System.out.println("能改变m本身的gift吗？能改变m的soldPrice吗？");

        m.describe();
    }
}
