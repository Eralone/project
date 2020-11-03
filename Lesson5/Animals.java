package Lesson5;

import java.util.Random;

public class Animals {


    private int run;
    private int swim;
    private float jump;

    public Animals(int run, int swim, float jump) {
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public Animals() {

        this.run = rand_anim(50,800);
        this.swim = rand_anim(20,600);
        this.jump = (float) rand_anim(1,3);
    }

    public int getRun() {
        return run;
    }

    public int getSwim() {
        return swim;
    }

    public float getJump() {
        return jump;
    }

    private static final int rand_anim (int minimum, int maximum) {
        Random Random = new Random();
        int x = 0;
        do {
            x = Random.nextInt(maximum);
        }while (x < minimum);
        return x;
    }




}
