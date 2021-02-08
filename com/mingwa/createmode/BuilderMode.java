package com.mingwa.createmode;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式：使用多个简单的对象一步一步构建成一个复杂的对象，属于创建者模式
 * 适用对象：复杂对象由于需求经常变动，然后复杂对象的子对象由一定的算法构成，将子对象组合在一起构成复杂对象的算法也保持相对稳定 -> 基本部件不变，组合经常变化
 */
public class BuilderMode {
    public static void main(String[] args) {
        // 获取蔬菜套餐：蔬菜汉堡 + 可乐
        prepareVegMeal().showItems();
        // 获取荤食套餐：鸡肉汉堡 + 百世
        prepareNoVegMeal().showItems();
    }

    // 汉堡和可乐对象都集成自Item对象，所以可以直接加到一个集合中，都有一定的共同点：包装+名称
    public static Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBuger());
        meal.addItem(new Coke());
        return meal;
    }

    public static Meal prepareNoVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

class Meal {
    private List<Item> itemList = new ArrayList<>();

    // 用来存储集体的项目：汉堡 / 饮料 / 其他的各种小食都可以，具有实现item的共同点：价格，名字，
    public void addItem(Item item) {
        itemList.add(item);
    }

    public void showItems() {
        itemList.forEach(item -> {
            System.out.println("item.name: " + item.name() + ", pack: " + item.packing().pack());
        });
    }
}

class ChickenBurger extends Buger {
    @Override
    public String name() {
        return "ChickenBuger";
    }
}

class VegBuger extends Buger {
    @Override
    public String name() {
        return "VegBuger";
    }
}

class Buger implements Item {
    @Override
    public String name() {
        // 此处如果是class会被子类覆写，所以抽象类好处是不用管这个方法的实现
        return null;
    }

    @Override
    public Package packing() {
        return new Paper();
    }
}

class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }
}

class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }
}

class ColdDrink implements Item {
    @Override
    public String name() {
        return null;
    }

    @Override
    public Package packing() {
        return new Bottle();
    }
}

class Bottle implements Package {
    @Override
    public String pack() {
        return "Bottle";
    }
}

class Paper implements Package {
    @Override
    public String pack() {
        return "Paper";
    }
}

interface Item {
    String name();
    Package packing();
}

interface Package {
    String pack();
}
