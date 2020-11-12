package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date of creation: 09.11.2020
 */

public class MainWindow extends JFrame { // подключение к библиотеке для создания какого-то окна

    private static final int WINDOW_WIDTH = 507; // константа длины окна по умолчанию
    private static final int WINDOW_HEIGHT = 555; // константа ширины окна по умолчанию
    private static final int WINDOW_POSX = 650; // положение окна по горезонтали по умолчанию (от левого верхнего угла монитора)
    private static final int WINDOW_POSY = 270; // положение окна по вертикали по умолчанию (от левого верхнего угла монитора)

    private Setting settingWindow; // переменная settingWindow типа Setting. Нужна, для того, чтобы выводить значение переменной в этом классе или вводить в переменную новое значение
    private GameMap gameMap; // переменная gameMap типа GameMap. Нужна, для того, чтобы выводить значение переменной в этом классе или вводить в переменную новое значение

    MainWindow() {  //Конструктор
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Если человек нажмет на закрытие (крестик), то закрой приложение
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Какие габариты окна по умолчанию
        setLocation(WINDOW_POSX, WINDOW_POSY); // Где он распологается по монитору
        setTitle("Игра: Крестики-нолики"); // сверху окна будет отражаться "Игра: Крестики-нолики"

        settingWindow = new Setting(this); // Создаем объект settingWindow типа Setting возвращающий самого себя
        gameMap = new GameMap();  // Создаем объект gameMap типа GameMap()

        JButton btnStart = new JButton("Create new game");  //Создаем кнопку btnStart
        btnStart.addActionListener(new ActionListener() {  //Добавляем к btnStart слушателя
            @Override  // уникально для этого класса
            public void actionPerformed(ActionEvent e) { // при нажатии кнопки - вызови метод,
                settingWindow.setVisible(true); // который скажает: появись settingWindow, который мы создали как объект в этом классе, но его конструктор в классе Setting.
            }
        });

        JButton btnExitGame = new JButton("<html><body><b>Close</b></body></html>"); // Создаем новую кнопку btnExitGame - благодоря html коду - текст Close отобразиться жирным
        btnExitGame.addActionListener(new ActionListener() { //Слушатель для btnExitGame
            @Override
            public void actionPerformed(ActionEvent e) {  //  При нажатии кнопки - вызови метод,
                System.exit(0); //  который при выходе из окна: 0- стопит приложение
            }
        });

        JPanel panelBottom = new JPanel(); //Создание поля panelBottom в окне
        panelBottom.setLayout(new GridLayout(1, 2)); // Создание табличного поля (1 строка, 2 столбца) в поле panelBottom
        panelBottom.add(btnStart); // В табличном поле, поля panelBottom будет помещаться кнопка btnStart
        panelBottom.add(btnExitGame); // В табличном поле, поля panelBottom будет помещаться кнопка btnExitGame

        add(panelBottom, BorderLayout.SOUTH); // поместить (показать) JPanel panelBottom в общем окне -снизу

        setResizable(false); // Сохранять непеременными настройки длины-ширины окна (нет)
        setVisible(true); // Выводить на экран окно (да) // Показывать данный метод в окне (да)
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) { // Критерии для старта игры, которые принимаються с Setting и отдаются в GameMap
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength); // Отдать в метод startNewGame, класса gameMap - значение переменных
    }
}
