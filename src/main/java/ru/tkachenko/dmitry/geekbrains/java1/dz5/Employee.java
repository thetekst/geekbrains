package ru.tkachenko.dmitry.geekbrains.java1.dz5;

/**
 * Created by dmitry tkachenko on 2/7/17.
 */

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000,30);
 * // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    Employee(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    static void getOver40old(Employee[] employees) {
        for (Employee employee : employees) {

            if (employee.age > 40) {
                System.out.println(employee.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
