package Lesson5;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat(200, 0,2);
        Dog dog1 = new Dog(500, 10, 0.5f);
        Horse horse1 = new Horse(1500, 100,3);
        Bird bird1 = new Bird(5, 0, 0.2f);
        dog1.go_run(150);
        cat1.go_jump(20f);
        horse1.go_swim(50);
        //Задание 5
        System.out.println("Задание 5:");
        System.out.println("Кошка 1:"); // вместо кошек, можно поставить объекты любого типа-наследника Animals
        Cat cat2 = new Cat();
        cat2.go_jump(2f);
        cat2.go_run(200);
        cat2.go_swim(100);
        System.out.println("Кошка 2:");
        Cat cat3 = new Cat();
        cat3.go_jump(2f);
        cat3.go_run(200);
        cat3.go_swim(100);


    }
}


