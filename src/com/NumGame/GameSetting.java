package com.NumGame;

public class GameSetting {
    // 游戏设置
    public int rangeStart;
    public int rangeEnd;
    public int guessTotal;
    // 是否结束游戏
    public boolean stopGame;

    public boolean guessCorrect;
    public int totalGameCount;
    public int totalCorrectCount;

    public void describe() {
        System.out.println("目标数已经生成，数字在" + rangeStart + "到" + rangeEnd + "之间，" +
                "不包括这两个数。共有" + guessTotal + "次猜测的机会。输入-1随时结束游戏。");
    }
    public int togame(int guessNum,int num,int guessLeft){
        if (guessNum == -1) {
            stopGame = true;
            return 1;
        }
        if (guessNum <= rangeStart || guessNum >= rangeEnd) {
            System.out.println("请输入在" + rangeStart + "到" + rangeEnd + "之间，的数字，不包括这两个数。");
            return 2;
        }
        if (guessNum == num)
        {
            totalCorrectCount++;
            guessCorrect = true;
            System.out.println("恭喜你猜对了！这次的数字就是" + num +
                    "。本次你共猜了" + (guessTotal - guessLeft) + "次。");
            return 1;
        }else if (guessNum > num) {
            System.out.println("猜测的数字比目标数字大。");
        } else {
            System.out.println("猜测的数字比目标数字小。");
        }
        return guessNum;
    }


    }
