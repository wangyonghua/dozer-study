package com.dozerstudy.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateTest {

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Orange extends Fruit {
    }

    public static void main(String[] args) {
        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());
        //list.add(new Fruit());

        Object apple = list.get(0);
    }
}
