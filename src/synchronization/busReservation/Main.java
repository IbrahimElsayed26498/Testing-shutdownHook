package synchronization.busReservation;

public class Main {
    public static void main(String[] args) {
        BusReservation br = new BusReservation();
        PassengerThread pTh1 = new
                PassengerThread(br, "Ibrahim", 2);
        PassengerThread pTh2 = new
                PassengerThread(br, "Mohamed", 2);

        pTh1.start();
        pTh2.start();
    }
}
