package org.example;
//          Функционал должен содержать добавление новых игрушек и задания веса для выпадения игрушек.
//        Задание
//        1) Напишите класс-конструктор у которого принимает минимум 3 строки,
//        содержащие три поля id игрушки, текстовое название и частоту выпадения
//        игрушки
//        2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три
//        массива.
//        3) Используя API коллекцию: java.util.PriorityQueue добавить элементы в
//        коллекцию
//        4) Организовать общую очередь
//        5) Вызвать Get 10 раз и записать результат в файл
//        В метод put передаете последовательно несколько строк
//        1 2 конструктор;
//        2 2 робот;
//        3 6 кукла.
//        Метод Get должен случайно вернуть либо “2”, либо “3” и соответствии с весом.
//        В 20% случаях выходит единица
//        В 20% двойка
//        И в 60% тройка.

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void foo(double chanceArr1, double chanceArr2, double chanceArr3, Toy t1, Toy t2, Toy t3, String res, Double random, FileWriter writer, int i) {
        random = Math.round((Math.random()) * 100.0) / 100.0;// 1..100

        if (random <= chanceArr1) {
            res = t1.nameToy; // 0,2 конструктор
        }
        if (random > chanceArr1 & random <= chanceArr2) {
            res = t2.nameToy; // 0,2 робот
        }
        if (random > chanceArr2) {
            res = t3.nameToy; // 0,6 кукла
        }
            String text = String.format(" Выпала игрушка -");
            System.out.println((i+1) +" " + text + " "+ res+" " + random);
        try {
            writer.append((i+1) +" " + text + " "+ res+" " + random);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Toy t1 = new Toy();
        t1.id = "1";
        t1.nameToy = "конструктор";
        t1.weight = "0.2";
        Toy t2 = new Toy();
        t2.id = "2";
        t2.nameToy = "робот";
        t2.weight = "0.2";
        Toy t3 = new Toy();
        t3.id = "3";
        t3.nameToy = "кукла";
        t3.weight = "0.6";
        String arr1[] = new String[2];
        arr1[0] = (t1.id);
        arr1[1] = (t1.weight);
        String arr2[] = new String[2];
        arr2[0] = t2.id;
        arr2[1] = t2.weight;
        String arr3[] = new String[2];
        arr3[0] = t3.id;
        arr3[1] = t3.weight;
        Double chanceArr1 = Double.parseDouble(arr1[1]);
        Double chanceArr2 = Double.parseDouble(arr2[1]) + chanceArr1;
        Double chanceArr3 = Double.parseDouble(arr3[1]) + chanceArr2;
        String res = "";
        Double random = 0.0;
        try (FileWriter writer = new FileWriter("toys.txt", false)) {
            for (int i = 0; i < 10; i++) {
                foo(chanceArr1, chanceArr2, chanceArr3, t1, t2, t3, res, random, writer,i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}