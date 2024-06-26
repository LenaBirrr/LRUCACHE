package com.company;

import fabric.LruCacheFabric;
import lru_cahe.ILruCache;
import menu.Menu;

import java.util.Scanner;
/*
Вариант 1
Реализовать фабрику (или фабричный метод), которая позволяет
получить объекты LruCache с указанными типами параметризации.
При этом возращаться должен экземпляр класса-прокси, который
добавляет к обычному классу следующее поведение:
• Каждый раз при достижении максимального размера кеша во
время вызова метода set() удаляемый элемент
(неиспользованный дольше всех) должен выводиться в консоль с
соотвествующим сообщением.
• При получении значения по ключу, т.е. при вызове get() , в
консоль должна выводиться история последних 10 обращений к
ключам, а именно - хронологическая последовательность ключей,
к которым были обращения.
• Кроме того, в сообщениях из предыдущих двух требований
должно содержаться время (в миллисекундах или наносекундах),
которое потребовалось обработку операции.*/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lruCacheType;
        LruCacheFabric<Integer, Integer>fabric = new LruCacheFabric<>();

        do {
            System.out.println("0 - обычный LRU-cache");
            System.out.println("1 - прокси LRU-cache с доп. информацией");
            lruCacheType=scanner.nextInt();
        }while(!(lruCacheType==0||lruCacheType==1));

        System.out.println("введите размер");
        ILruCache<Integer,Integer> lruCache=fabric.CreateLruCache(lruCacheType,scanner.nextInt());

        Menu menu=new Menu(lruCache);
        menu.Manipulate();
    }
}
