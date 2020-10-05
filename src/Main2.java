
public class Main2 {
    public static void main(String[] args) throws Exception{
        //Runtime.getRuntime().exec("notepad");

        // show details of memory
        memoryDetails();

        System.out.println("creating objects...");
        // create many objects
        for (int i = 0; i < 9999999; i++) {
            new Main2();
        }
        // show memory details after creating the many objects.
        memoryDetails();

        // use the garbage collector to erase the unused objects.
        System.out.println("Using GC");
        System.gc();

        // show memory details after using gc.
        memoryDetails();
    }
    static void memoryDetails(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memory Space.");
        System.out.println("-------------");

        System.out.println("Total |" + runtime.totalMemory());
        System.out.println("Max   |" + runtime.maxMemory());
        System.out.println("Free  |" + runtime.freeMemory());
        System.out.println("Used  |" +
                (runtime.totalMemory() - runtime.freeMemory()));
        System.out.println("================================");
    }
}
