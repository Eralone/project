package Lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date of creation: 09.11.2020
 */

public class Setting extends JFrame {  // подключение к библиотеке для создания какого-то окна

    private static final int WINDOW_WIDTH = 350; // константа длины окна Setting по умолчанию
    private static final int WINDOW_HEIGHT = 270; // константа ширины окна Setting по умолчанию

    private static final int MIN_WIN_LENGTH = 3; //Минимальное поле для победы
    private static final int MIN_FIELD_SIZE = 3; // Минимальное поле игры
    private static final int MAX_FIELD_SIZE = 10; // Максимальное поле игры
    private static final String FIELD_SIZE_PREFIX = "Field size is: "; //текст, который будет написан в setting до настройки поля игры
    private static final String WIN_LENGTH_PREFIX = "Win length is: "; //текст, который будет написан в setting до настройки поля для победы

    private MainWindow mainWindow; //ссылка на метод, в который будет записываться mode, fieldSizeX, fieldSizeY, winLength

    private JRadioButton humVSAI; // Создание переменной для альтернативной настройки (или, или)
    private JRadioButton humVSHum; // Создание переменной для альтернативной настройки (или, или)
    private JSlider slideWinLen; // Создание переменной для бегунка, меняющего поле победы
    private JSlider slideFieldSize; // Создание переменной для бегунка, меняющего поля игры


    Setting(MainWindow mainWindow) { //конструктор всплывающего окна (объекта) Setting, который принадлежит объекту MainWindow и пользуется его конструктором

        this.mainWindow = mainWindow; // передача переменных mainWindow из метода MainWindow в константную переменную этого класса mainWindow
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // параметры всплывающего окна Setting (длина, высота) из констант
        Rectangle gameWindowBounds = mainWindow.getBounds(); // задание прямоугольника gameWindowBounds по параметрам (длина, ширина) конструктора объекта mainWindow
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2; // берем центр этого прямоуголькика по ширине (значение, цифру) и минусуем от него ширину окна setting деленную на 2, сохраняя информацию в int и помещаем значение posX
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2; // берем центр этого прямоуголькика по высоте (значение, цифру) и минусуем от него высоту окна setting деленную на 2, сохраняя информацию в int и помещаем значение posY
        setLocation(posX, posY); // Указываем место локации объекта Setting по длине и ширине, указанную на строчках 38-39
        setResizable(false); // Сохранять непеременными настройки длины-ширины окна (нет)
        setTitle("Settings new game"); // Указание в название окна (сверху) Settings new game
        setLayout(new GridLayout(10, 1)); // переопределение, вместо окна BorderLayout создаеться окно GridLayout с 10тью строками и 1 столбцом

        addGameModeSetup(); // Проведи метод addGameModeSetup (61-70 строка)
        addFieldMapControl(); // Проведи метод addFieldMapControl (72-84 строка)


        JButton btnPlay = new JButton("Play new game!!"); // Сделай кнопку
        btnPlay.addActionListener(new ActionListener() {  //И помести в ней слушателя
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayGameClick();
            } // Слушатель будет при нажатии кнопки воспроизводить метод btnPlayGameClick
        });

        add(btnPlay); // Добавить кнопку в окно
        setVisible(false); // По умолчанию не показывать данное окно

        ColorWindow ();

    }

    private void addGameModeSetup() {
        add(new JLabel("Choose game mode:")); // добавить текст в окне Setting
        humVSAI = new JRadioButton("Human vs. AI", true); // Объект альтернативной настройки (или/или)
        humVSHum = new JRadioButton("Human vs. Human"); // Объект альтернативной настройки (или/или)
        ButtonGroup gameMode = new ButtonGroup(); // Создание места для группы альтернативных настроек (или/или)
        gameMode.add(humVSAI); // Объект humVSAI помещается в группу для альтернативных настроек
        gameMode.add(humVSHum); // Объект humVSHum помещается в группу для альтернативных настроек
        add(humVSAI); // Добавить альтернативную настройку в окно
        add(humVSHum); // Добавить альтернативную настройку в окно
    }

    private void addFieldMapControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE); // текст, который будет написан в setting до настройки поля игры + минимальное поле, обновляемое при изменении
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH); //текст, который будет написан в setting до настройки поля для победы + минимальное поля для выйгрыша, обновляемое при изменении

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE); // Бегунок, который начинается с минимального поля, заканчивается максимльным, а по умолчанию стоит минимальный размер поля
        slideFieldSize.addChangeListener(new ChangeListener() { // Наполни данный бегунок слушателем
            @Override
            public void stateChanged(ChangeEvent e) { // В случаи, если на него нажмут
                int currentValue = slideFieldSize.getValue(); // Дай значение, куда бегунок перенесли в переменную currentValue
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue); // Поменяй текст lbFieldSize на текст, который будет написан в setting до настройки поля игры + цифра, куда перенесли бегунок
                slideWinLen.setMaximum(currentValue); // максимальное значение slideWinLen = currentValue
            }
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE); // Бегунок, который начинается с минимального поля для победы, заканчивается минимальным полем игры, а по умолчанию стоит минимальное поле игры
        slideWinLen.addChangeListener(new ChangeListener() {  // Наполни данный бегунок слушателем
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            } // при изменении бегунка - измени текст lbWinLength и добавь туда значение, которое поставили в бегунке, но не больше, чем currentValue из slideFieldSize
        });

        add(new JLabel("Choose field map size")); // создай новый текст и сразу помести его в окно
        add(lbFieldSize); // покажи текст
        add(slideFieldSize);  //  и бегунок для игрового поля
        add(new JLabel("Choose win length")); // создай новый текст и сразу помести его в окно
        add(lbWinLength); // покажи текст
        add(slideWinLen); // и бегунок для поля выйгрыша
    }

    private void btnPlayGameClick() {
        int gameMode;

        if (humVSAI.isSelected()) { // если выбран humVSAI
            gameMode = GameMap.MODE_HVA; // то переменная gameMode = значению MODE_HVA (0)
        } else if (humVSHum.isSelected()) { // если выбран humVSHum
            gameMode = GameMap.MODE_HVH; // то переменная gameMode = значению MODE_HVH (1)
        } else { //Если нет
            throw new RuntimeException("Unexpected game mode!"); //То выведи - неизвестный мод
        }

        int fieldSize = slideFieldSize.getValue(); // Переменная равна значению бегунка slideFieldSize
        int winLength = slideWinLen.getValue(); // Переменная равна значению бегунка slideWinLen

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength); // Вернуть значения данных переменных в метод startNewGame, класса mainWindow

    }

    private void ColorWindow () {

        JLabel textColorWindow = new JLabel("Choose color: ");

        JButton writeW = new JButton("White");
        writeW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeW.setBackground(Color.WHITE);;
            }
        });

        JButton blackW = new JButton("Black");
        blackW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blackW.setBackground(Color.black);
            }
        });
        JButton redW = new JButton("Red");
        redW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redW.setBackground(red);
            }
        });

        JPanel panelWindow = new JPanel();
        panelWindow.setLayout(new GridLayout(1, 2));
        JLabel zero1 = new JLabel("");

        add(textColorWindow);
        add(zero1);
        panelWindow.add(writeW);
        panelWindow.add(blackW);
        add(redW);
        add(panelWindow);




            }
        }



