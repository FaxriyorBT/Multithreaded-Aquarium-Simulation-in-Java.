import java.util.concurrent.CopyOnWriteArrayList;

public class Aquarium {
    private static final CopyOnWriteArrayList<Fish> fishes = new CopyOnWriteArrayList<>();
    public static final Integer width = 10 , height = 10;
    public static final Integer maxSize = 50;


    public static void addFish(Fish fish) {
        fishes.add(fish);
        new Thread (fish).start();
    }
    public static void removeFish(Fish fish) {
        fishes.remove(fish);
    }

    public static void ifParent(Fish fish1, Fish fish2){
            System.out.println(("!!! --------------  Baliqlar uchrashishdi -------------- !!!\n" +
                    "fish1 : " + fish1 + "\n fish2 : " + fish2 +"\n -------------------------------------------"));
            Fish newFish = new Fish();
            addFish(newFish);

            System.out.println("-------------- New Fish added --------------\n" +
                    "Ota-Onasining idlari: " + fish1.getId() + " va "+ fish2.getId() + " \n" + newFish + "\n" +
                    "Aquariumda Baliqlar soni: " + fishes.size() + "\n" +
                    "---------------------and------------------------\n " );
            if (fish1.getGender() == Gender.MALE){
                newFish.setFatherId(fish1.getId());
            }if (fish1.getGender() == Gender.FEMALE){
                newFish.setMotherId(fish1.getId());
            }if (fish2.getGender() == Gender.FEMALE){
                newFish.setMotherId(fish2.getId());
            }
            if (fish2.getGender() != Gender.MALE) {
                newFish.setFatherId(fish2.getId());
            }
    }


    public static void meetFish(Fish fish1) {
        if (maxSize >= fishes.size()) {
            for(Fish fish2 : fishes) {
                if (fish1.getGender() != fish2.getGender() && fish2.getAge() >= 18) {
                    if(fish1.getX() == fish2.getX() && fish1.getY() == fish2.getY()) {
                        if (fish1.getFatherId() == 0 && fish2.getFatherId() == 0){
                            ifParent(fish1,fish2);
                        }
                        if (fish1.getMotherId() != fish2.getMotherId() && fish1.getFatherId() != fish2.getFatherId()) {
                            ifParent(fish1,fish2);
                        }
                    }
                }
            }
        }
    }
}












