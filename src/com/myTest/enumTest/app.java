package com.myTest.enumTest;

/**
 * Created by winkey on 15-2-4.
 */
public class app {
     enum Color {
         RED,GREEN,YELLOW
       }

    public static void main(String[] args) {
        System.out.println(Color.valueOf("RED"));
        Color color = Color.valueOf("RED");
        switch (color){
            case RED:
                System.out.println("hong");
                break;
            case GREEN:
                System.out.println("lv");
                break;
        }
    }
}
