package com.mingwa.createmode;

public class SingletonMode {

    public static void main(String[] args) {

        // 使用枚举获取单例对象
        SingletonEnumMode type = SingletonEnumMode.INSTANCE;


        // 使用懒汉模式获取单例对象
        SingleLazyMode lazyInstance = SingleLazyMode.getInstance();
    }
}

/**
 * 单例模式：懒汉式获取单例对象
 */
class SingleLazyMode {

    /**
     * 私有化构造
     */
    private SingleLazyMode() {}

    public static SingleLazyMode getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 静态内部类只有在用时才会被加载
     */
    private static class SingletonHolder {
        private static final SingleLazyMode instance = new SingleLazyMode();
    }
}

/**
 * 单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 */
 enum SingletonEnumMode {
    INSTANCE;
}
