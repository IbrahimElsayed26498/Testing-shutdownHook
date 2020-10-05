package synchronization;

public class SynchronizationBlock {
    public static void main(String[] args) {
        TableSyncBlock t = new TableSyncBlock();

        Thread th = new Thread(() -> t.printTable(5));
        Thread th1 = new Thread(() -> t.printTable(6));
        Thread th2 = new Thread(() -> t.printTable(7));

        th.start();
        th1.start();
        th2.start();
    }
}
class TableSyncBlock {


    void printTable(int n){
        synchronized (this){
            System.out.println("Sync block starts......" + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(n * i);
                
            }
            System.out.println("Sync block ends...." + Thread.currentThread().getName());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + " => " + i);
            try{
                Thread.sleep(400);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}