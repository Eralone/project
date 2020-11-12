package Lesson4;

public class Worker {

    String name;
    String position;
    String tel;
    int salary;
    int age;
    int id;

    public Worker(String name, String position, String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
        this.id= this.id + 1;
        autoid();


    }

    int autoid(){
        return this.id;
    }

    void printname() {
        System.out.println(name);
    }

    void printposition() {
        System.out.println(position);
    }

    void printtel() {
        System.out.println(tel);
    }

    void printsalary() {
        System.out.println(salary);
    }

    void printage() {
        System.out.println(age);
    }

    void printNameAndPosit() {
        printname();
        printposition();
    }

    public static void main(String[] args) {
        Worker[] worker = new Worker[6];
        worker[1] = new Worker("Philip Anthony McKinney", "manager", "8(999)999-88-77", 2600, 20);
        worker[2] = new Worker("Thomas Curtis Campbell", "purchasing manager", "8(800)555-35-35", 5000, 25);
        worker[3] = new Worker("Albus Percival Wulfric Brian Dumbledore", "director", "+44(123)456-78-90", 20000, 115);
        worker[4] = new Worker("Walter Geoffrey Stevens", "sales manager", "8(700)600-50-40", 7000, 35);
        worker[5] = new Worker("Maurice Jonah Eaton", "janitor", "8(123)456-78-90", 2000, 65);


        for (int i = 1; i <= 5; i++) {
            if (worker[i].age >= 40) {
                System.out.println(worker[i].name + " | " + worker[i].position + " | " + worker[i].age + " |  - Homework5");
            }
        }
        for (int j = 1; j <= 5; j++) {
            if (worker[j].age >= 45) {
                System.out.println(worker[j].name + " До: " + worker[j].salary + " | - Homework6");
                worker[j].salary = worker[j].salary + 5000;
                System.out.println(worker[j].name + " После: " + worker[j].salary + " | - Homework6");
            }
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println(worker[i].id + " | " + worker[i].name + " | - Homework7");
        }
    }
}




