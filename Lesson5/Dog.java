package Lesson5;

public class Dog extends Animals {

    public Dog (int run, int swim, float jump) {
        super(run, swim, jump);
    }

    public Dog () {
        super();
    }


    public void go_run (int run_dear) {
        if( getRun() >= run_dear) {
            System.out.println("Песик пробежал, он мог бы пробежать еще " + (getRun() - run_dear) + " метров");
        }
        else
            System.out.println("Песик не смог пробежать, ему не хватило " + (run_dear - getRun()) + " метров");
    }

    public void go_jump (float icfly) {
        if( getJump() >= icfly) {
            System.out.println("Песик допрыгнул, он мог бы прыгнуть еще больше на " + (getJump() - icfly) + " метров");
        }
        else
            System.out.println("Песик не смог допрыгнуть, ему не хватило " + (icfly - getJump()) + " метров");
    }

    public void go_swim (int swim_dear) {
        if( getSwim() >= swim_dear) {
            System.out.println("Песик проплыл, он мог бы проплыть еще " + (getSwim() - swim_dear) + " метров");
        }
        else
            System.out.println("Песик не смог проплыть, ему не хватило " + (swim_dear -getSwim()) + " метров. Спасай его!");
    }



}
