package ru.tkachenko.dmitry.geekbrains.java2.task1;

import ru.tkachenko.dmitry.geekbrains.java2.task1.competitors.*;
import ru.tkachenko.dmitry.geekbrains.java2.task1.course.*;

/**
 * Created by dmitry tkachenko on 2/21/17.
 * <p>
 * 1. Разобраться с имеющимся кодом;
 * <p>
 * 2. Добавить класс Команда, который будет содержать: название команды, массив из 4х
 * участников (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода
 * информации о членах команды прошедших дистанцию, метод вывода информации обо всех
 * членах команды.
 * <p>
 * 3. Добавить класс ПолосаПрепятствий, в котором будут находиться: массив препятствий, метод
 * который будет просить команду пройти всю полосу;
 * То есть в итоге должно быть что-то вроде:
 * public static void main(String[] args) {
 * Course c = new Course(...); // Создаем полосу препятствий
 * Team t1 = new Team(...); // Создаем первую команду
 * Team t2 = new Team(...); // Создаем вторую команду
 * c.doIt(t1); // Просим первую команду пройти полосу
 * c.doIt(t2); // Просим вторую команду пройти полосу
 * t1.showResults(); // Показываем результаты первой команды
 * t2.showResults(); // Показываем результаты второй команды
 * }
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class Task1 {
    public static void main(String[] args) {

        Obstacle[] obstacle = {new Cross(300), new Wall(2),
                new Cross(800), new Water(5)};
        Course course1 = new Course(obstacle);

        Competitor[] competitors = {new Human("Bob"), new Cat("Barsik"),
                new Dog("Bobik"), new Dog("Sharik")};

        Team team1 = new Team("Team 1", competitors);

        Team team2 = new Team("Team 2", new Competitor[]{
                new Human("Molly"), new Cat("Frank"),
                new Dog("Tom"), new Dog("Chip")});


        course1.doIt(team1);
        course1.doIt(team2);

        System.out.println("\n===== RESULTS =====\n");
        team1.showResults();
        System.out.println();
        team2.showResults();
    }
}
