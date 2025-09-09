import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Aquarium sig'imini kiritish>>>");
//        int aquariumCapacity = scan.nextInt();
//        System.out.println("Boshlangich nechta Baliq bo'lsin>>>");
//        int fishS = scan.nextInt();

//        Aquarium.maxSize = aquariumCapacity ;
       for (int i = 1; i <= 20; i++) {
           Fish fish = new Fish();
           Aquarium.addFish(fish);
       }
    }
}