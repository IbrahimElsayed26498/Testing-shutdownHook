// In the name of Allah, the Gracious, the Merciful

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new TestShutdownHook());

        System.out.println("Your computer is in sleep mode, Press ctrl+c to exit.");
        try{
            Thread.sleep(60000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

class TestShutdownHook extends Thread{
    public void run(){
        System.out.println("Shutdown your task completed.");
    }
}
