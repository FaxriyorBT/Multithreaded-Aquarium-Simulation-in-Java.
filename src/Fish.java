import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Fish implements Runnable{
    private final Gender gender;
    private final int id;
    private final Integer maxAge = random.nextInt(60,101);;
    private Integer age;
    private Integer x,y;
    private int FatherId;
    private int MotherId;

    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private static final Random random = new Random();

    public Fish() {
        this.gender = Gender.getRandomGender();
        this.age = 1;
        this.id = idCounter.incrementAndGet();
        this.x = random.nextInt(1,11);
        this.y = random.nextInt(1, 11);
        this.setFatherId(0);
        this.setMotherId(0);

    }
    @Override
    public void run() {
        while (maxAge>=age){
            swim();
            System.out.println(this);
                if (age >=18) {
                    Aquarium.meetFish(this);
                }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            age++;
        }
        Aquarium.removeFish(this);

    }
    public void swim(){
        do {
            int tempX = x + random.nextInt(3)-1;
            if (tempX > 0){
                x = tempX;
            }

        }while (x > Aquarium.width);

        do {
            int tempY = y + random.nextInt(3)-1;
            if (tempY > 0){
                y = tempY;
            }
        }while (y > Aquarium.height);

    }

    public void setFatherId(Integer fatherId) {
        FatherId = fatherId;
    }

    public void setMotherId(Integer motherId) {
        MotherId = motherId;
    }

    public int getFatherId() {
        return FatherId;
    }

    public int getMotherId() {
        return MotherId;
    }

    public int getAge() {
        return age;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Gender getGender() {
        return gender;
    }
    public int getId() {
        return id;
    }

    @Override
    public synchronized String toString() {
        return   String.format("""
             |---------------------------
             |       Baliq id: %d
             |       Baliqning yoshi: %d
             |       Baliqning x kordinatasi: %d
             |       Baliqning y kordinatasi: %d
             |       Baliqning genderi: %s
             |       Baliqning maxAge: %d
             |-----------------------------  \s
               \s""",this.id,this.getAge(),this.getX(),this.getY(),this.getGender(),this.maxAge);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
