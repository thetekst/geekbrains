package ru.tkachenko.dmitry.geekbrains.java1.dz6;

import ru.tkachenko.dmitry.geekbrains.java1.dz6.cats.Cat;
import ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs.DogBig;
import ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs.DogRandom;
import ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs.DogSmall;

/**
 * Created by dmitry tkachenko on 2/10/17.
 *
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 *
 * 2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
 * параметра каждому методу передается величина, означающая или длину препятствия (для
 * бега и плавания), или высоту (для прыжков).
 *
 * 3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
 * прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
 *
 * 4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
 * консоль. (Например, dog1.run(150); -> результат: run: true)
 *
 * 5 * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
 * может быть 400 м., у другой 600 м.
 */
public class Dz6 {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new DogSmall(), new DogBig(), new DogRandom()};

        for (Animal animal : animals) {
            System.out.printf("%s run: %s\n",
                    animal.getClass().getSimpleName(),
                    animal.run(201));

            System.out.printf("%s jump: %s\n",
                    animal.getClass().getSimpleName(),
                    animal.jump(0.5));

            System.out.printf("%s swim: %s\n\n",
                    animal.getClass().getSimpleName(),
                    animal.swim(8));
        }

        Animal cat = new Cat();
        Animal dogSmall = new DogSmall();
        Animal dogBig = new DogBig();

        assert !cat.run(201);
        assert cat.run(200);

        assert !dogSmall.run(0);
        assert !dogSmall.run(351);
        assert dogSmall.run(350);

        assert dogBig.run(351) == true;
        assert dogBig.run(560) == true;
        assert dogBig.run(561) == false;
    }
}
