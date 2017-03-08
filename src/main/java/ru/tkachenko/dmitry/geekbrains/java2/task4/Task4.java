package ru.tkachenko.dmitry.geekbrains.java2.task4;

import javax.swing.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/4/17
 *
 * Создать окно для клиентской части чата: большое текстовое поле для отображения переписки
 * в центре окна. Однострочное текстовое поле для ввода сообщений и кнопка для отсылки
 * сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на
 * форме, либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из нижнего
 * поля в центральное.
 */


public class Task4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Frame::new);
    }
}
