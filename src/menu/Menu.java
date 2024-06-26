package menu;

import lru_cahe.ILruCache;


import java.util.Scanner;

public class Menu {
    private final ILruCache lruCache;
    private final Scanner scanner=new Scanner(System.in);
    public Menu(ILruCache lruCache)
    {
        this.lruCache=lruCache;
    }
    private void setElem()
    {
        System.out.println("Введите через пробел пару чисел ключ-значение:");
        lruCache.set(scanner.nextInt(), scanner.nextInt());
    }

    private void getElem()
    {
        System.out.println("Введите ключ:");

        System.out.println("Зачение: "+lruCache.get(scanner.nextInt()));

    }

    public void Manipulate()
    {
        int option;
        do {
            System.out.println("0 - закончить работу:");
            System.out.println("1- добавить значение");
            System.out.println("2 - получить значение по ключу");
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
            }

        }while(option!=0);

    }
}
