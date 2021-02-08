package com.mingwa.createmode;

/**
 * 工厂模式：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 */
public class FactoryMode {

    public static Sharp getSharp(String type) {
        if ("cicle".equalsIgnoreCase(type)) {
            return new Cicle();
        } else if ("square".equalsIgnoreCase(type)) {
            return new Square();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Sharp sharp = getSharp("cicle");
        sharp.draw();
        Sharp sharp2 = getSharp("square");
        sharp2.draw();
    }
}

interface Sharp {
    void draw();
}

class Cicle implements Sharp {
    @Override
    public void draw() {
        System.out.println("draw cicle");
    }
}

class Square implements Sharp {
    @Override
    public void draw() {
        System.out.println("draw square");
    }
}
