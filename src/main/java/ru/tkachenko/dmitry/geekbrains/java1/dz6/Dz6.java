package ru.tkachenko.dmitry.geekbrains.java1.dz6;

import ru.tkachenko.dmitry.geekbrains.java1.dz6.cats.Cat;
import ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs.DogBig;
import ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs.DogSmall;

/**
 * Created by dmitry tkachenko on 2/10/17.
 * <p>
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
 * параметра каждому методу передается величина, означающая или длину препятствия (для
 * бега и плавания), или высоту (для прыжков).
 * 3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
 * прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
 * 4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
 * консоль. (Например, dog1.run(150); -> результат: run: true)
 * 5 * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
 * может быть 400 м., у другой 600 м.
 */
public class Dz6 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dogSmall = new DogSmall();
        Animal dogBig = new DogBig();

        System.out.printf("%s run: %s\n", cat.getClass().getSimpleName(), cat.run(201));
        System.out.printf("%s run: %s\n", dogSmall.getClass().getSimpleName(), dogSmall.run(400));
        System.out.printf("%s run: %s\n\n", dogBig.getClass().getSimpleName(), dogBig.run(500));

        System.out.printf("%s jump: %s\n", cat.getClass().getSimpleName(), cat.jump(1));
        System.out.printf("%s jump: %s\n", dogSmall.getClass().getSimpleName(), dogSmall.jump(0.5));
        System.out.printf("%s jump: %s\n\n", dogBig.getClass().getSimpleName(), dogBig.jump(0.5));

        System.out.printf("%s swim: %s\n", cat.getClass().getSimpleName(), cat.swim(201));
        System.out.printf("%s swim: %s\n", dogSmall.getClass().getSimpleName(), dogSmall.swim(3));
        System.out.printf("%s swim: %s\n\n", dogBig.getClass().getSimpleName(), dogBig.swim(10));
    }
}
