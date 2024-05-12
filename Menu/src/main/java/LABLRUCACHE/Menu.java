package LABLRUCACHE;

import LABLRUCACHE.fabric.LruCacheFabric;
import LABLRUCACHE.lru_cahe.ILruCache;


import java.io.InputStream;
import java.util.Scanner;

public class Menu {
    private final ILruCache lruCache;
    private final Scanner scanner;
    public Menu(ILruCache lruCache, InputStream stream)
    {
        this.lruCache=lruCache;
        this.scanner=new Scanner(stream);
    }
    public void setElem()
    {
        System.out.println("Введите через пробел пару чисел ключ-значение:");
        lruCache.set(scanner.nextInt(), scanner.nextInt());
    }

    public void getElem()
    {
        System.out.println("Введите ключ:");

        System.out.println("Зачение: "+lruCache.get(scanner.nextInt()));

    }
    private void getSize()
    {
        System.out.println("Введите ключ:");

        System.out.println("Размер кэша: "+ lruCache.getSize());

    }

    public void Manipulate()
    {
        int option;
        do {
            System.out.println("0 - закончить работу:");
            System.out.println("1- добавить значение");
            System.out.println("2 - получить значение по ключу");
            System.out.println("3 - узнать текущий размер кэша");
            option=scanner.nextInt();
            switch (option)
            {
                case 1 -> {
                    setElem();
                    break;
                }
                case 2->{
                    getElem();
                    break;
                }
                case 3->{
                    getSize();
                    break;
                }
            }

        }while(option!=0);

    }
}
