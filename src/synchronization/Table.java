package synchronization;

class Main{
    public static void main(String[] args) {
        Table t = new Table();
        MyThread1 MyTh1 = new MyThread1(t);
        MyThread2 MyTh2 = new MyThread2(t);
        Thread th = new Thread(){
            @Override
            public void run() {
                t.printTable(200);
            }
        };


        MyTh1.start();
        MyTh2.start();
        th.start();
    }
}
public class Table{

    // It makes the thread finish first,
    // then goes to the next one.
    synchronized void printTable(int n){
        for (int i = 0; i < 5; i++) {
            System.out.println(n * i);
            try{
                Thread.sleep(400);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
class MyThread1 extends Thread{
    Table t;
    public MyThread1(Table t){
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread{
    Table t;
    public MyThread2(Table t){
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}