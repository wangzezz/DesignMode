package com.mingwa.createmode;

/**
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 */
public class AbstractFactoryMode {

    public static void main(String[] args) {
        AbstractFactorys sharpFactory = getFactory("SHARP");
        Sharps sharp1 = sharpFactory.getSharps("CICLE");
        sharp1.draw();

        AbstractFactorys colorFactory = getFactory("COLOR");
        Color color = colorFactory.getColor("red");
        color.drawColor();
    }

    public static AbstractFactorys getFactory(String choice) {
        if ("SHARP".equalsIgnoreCase(choice)) {
            return new sharpFactory();
        } else {
            return new colorFactory();
        }
    }
}

class sharpFactory extends AbstractFactorys {

    @Override
    public Sharps getSharps(String sharp) {
        if ("cicle".equalsIgnoreCase(sharp)) {
            return new Cicles();
        } else {
            return new Squares();
        }
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}

class colorFactory extends AbstractFactorys {

    @Override
    public Color getColor(String sharp) {
        if ("red".equalsIgnoreCase(sharp)) {
            return new Red();
        } else {
            return new Green();
        }
    }

    @Override
    public Sharps getSharps(String color) {
        return null;
    }

}

abstract class AbstractFactorys {
    public abstract Sharps getSharps(String sharp);
    public abstract Color getColor(String color);
}

interface Sharps {
    void draw();
}

class Cicles implements Sharps {
    @Override
    public void draw() {
        System.out.println("draw cicle");
    }
}

class Squares implements Sharps {
    @Override
    public void draw() {
        System.out.println("draw square");
    }
}

interface Color {
    void drawColor();
}

class Red implements Color {
    @Override
    public void drawColor() {
        System.out.println("print red");
    }
}

class Green implements Color {
    @Override
    public void drawColor() {
        System.out.println("print green");
    }
}
