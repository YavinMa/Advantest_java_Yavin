package com.NumGame;

import java.util.Scanner;

public class Guess_Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GameSetting setting = new GameSetting();
        setting.rangeStart = 1;
        setting.rangeEnd = 8;
        setting.guessTotal = 5;
        setting.stopGame = false;
        // 游戏统计
        setting.totalGameCount = 0;
        setting.totalCorrectCount = 0;

        while (!setting.stopGame) {
            // 初始化本次游戏的变量
            int guessLeft = setting.guessTotal;
            int mod = setting.rangeEnd - setting.rangeStart;
            double randNum = Math.random();
            int num = ((int) (randNum * setting.rangeEnd * 100)) % mod;
            num += setting.rangeStart;
            if (num <= setting.rangeStart) {
                num = setting.rangeStart + 1;
            }
            if (num >= setting.rangeEnd) {
                num = setting.rangeEnd - 1;
            }

            setting.describe();

            // 本次游戏是否开始了
            boolean gameStart = true;
            // 本次是否猜中数字
            setting.guessCorrect = false;



            while (guessLeft > 0) {
                System.out.println("还有" + guessLeft + "次机会，请输入猜测的数字，回车确认");
                int guessNum = in.nextInt();
                int condition = setting.togame(guessNum,num,guessLeft);
                if (condition == 1)
                    break;
                else if (condition == 2)
                    continue;
                if (gameStart) {
                    setting.totalGameCount++;
                    gameStart = false;
                }
                guessLeft--;
            }
            if (!setting.guessCorrect) {
                System.out.println("本次的目标数字是" + num + "。这次没有猜中。");
            }
        }

        System.out.println("共进行了" + setting.totalGameCount + "次游戏，其中正确的为" + setting.totalCorrectCount + "次");
    }
}
