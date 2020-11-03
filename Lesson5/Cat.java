package Lesson5;

public class Cat extends Animals {

    public Cat (int run, int swim, float jump) {
        super(run, swim, jump);
    }

    public Cat () {
        super();
    }

    public void go_run (int run_dear) {
        if (getRun() >= run_dear) {
            System.out.println("Кошка пробежала, она могла бы пробежать еще " + (getRun() - run_dear) + " метров");
        } else
            System.out.println("Кошка не смогла пробежать, ей не хватило " + (run_dear - getRun()) + " метров");
    }

    public void go_jump (float icfly) {
        if( getJump() >= icfly) {
            System.out.println("Кошка допрыгнула, она могла бы прыгнуть еще больше на " + (getJump() - icfly) + " метров");
        }
        else
            System.out.println("Кошка не смогла допрыгнуть, ей не хватило " + (icfly - getJump()) + " метров");
    }

    public void go_swim (int swim_dear) {
        if (getSwim() >= swim_dear) {
            System.out.println("Кошка проплыла, она могла бы проплыть еще " + (getSwim() - swim_dear) + " метров");
        } else
            System.out.println("Кошка не смогла проплыть, ей не хватило " + (swim_dear - getSwim()) + " метров. Спасай ее!");
    }

}
