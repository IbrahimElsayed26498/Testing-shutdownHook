package synchronization.busReservation;

public class PassengerThread extends Thread{
    private int seatNeeded;

    public PassengerThread(Runnable target, String name, int seatNeeded) {
        super(target, name);
        this.seatNeeded = seatNeeded;
    }

    public int getSeatNeeded() {
        return seatNeeded;
    }
}
