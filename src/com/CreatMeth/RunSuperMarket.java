package com.CreatMeth;

import com.CreatMeth.Supermarket.SuperMarket;
import com.CreatMeth.Supermarket.Merchandise;
public class RunSuperMarket {

    public static void main(String[] args) {
        // 创建一个小超市类
        SuperMarket littleSuperMarket = new SuperMarket(
                "有家小超市", "浦东大道520号",
                100, 200, 200);

        System.out.println("VIP的折上折折扣最终为：" + Merchandise.getDiscountOnDiscount(littleSuperMarket));

    }
}

