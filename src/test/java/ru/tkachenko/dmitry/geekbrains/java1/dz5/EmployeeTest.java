package ru.tkachenko.dmitry.geekbrains.java1.dz5;

import org.junit.Test;

/**
 * Created by dmitry tkachenko on 2/7/17.
 */
public class EmployeeTest {
    private final int COUNT = 5;
    private Employee[] employee;

    public EmployeeTest() {
        employee = new Employee[COUNT];

        employee[0] = new Employee("P1 Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employee[1] = new Employee("P2 Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 41);
        employee[2] = new Employee("P3 Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employee[3] = new Employee("P4 Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 56);
        employee[4] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
    }

    @Test
    public void getOver40oldTest() {
        Employee.getOver40old(employee);
    }
}