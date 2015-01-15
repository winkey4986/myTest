package com.myTest.singleton;

/**
 * Created by winkey on 15-1-15.
 */
public class SingletonClass {
    private static  SingletonClass singletonClass = null;
    public static SingletonClass getInstance(){
        if (singletonClass==null){
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }
    private SingletonClass(){}
}
