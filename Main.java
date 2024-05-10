public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addNewToy(1, "Doll", 10, 20);
        toyStore.addNewToy(2, "Car", 15, 30);
        toyStore.addNewToy(3, "Teddy Bear", 12, 25);
        toyStore.addNewToy(4, "Puzzle", 20, 25);

        toyStore.changeFrequency(2, 10);

        toyStore.drawToys(3);

        toyStore.awardPrizeToy();


        
    }

}
