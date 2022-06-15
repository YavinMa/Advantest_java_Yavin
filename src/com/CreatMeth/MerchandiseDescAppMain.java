package com.CreatMeth;
import com.CreatMeth.Supermarket.Merchandise;
import  static com.CreatMeth.Supermarket.Merchandise.getVIPDiscount;

public class MerchandiseDescAppMain {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise
                ("Êé×À", "DESK5207", 40, 999.9, 300);

        merchandise.describe();

        System.out.println(getVIPDiscount());

    }
}
