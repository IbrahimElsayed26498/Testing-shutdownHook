package synchronization.busReservation;

public class BusReservation implements Runnable{
    private int totalSeatsAvailable = 2;

    @Override
    public void run() {
        PassengerThread pTh = (PassengerThread) Thread.currentThread();
        boolean ticketsBooked =
                this.bookTickets(pTh.getSeatNeeded(), pTh.getName());

        if (ticketsBooked){
            System.out.printf("GONGRATULATIONS %s The number of seat requested %d are Booked%n",
                            Thread.currentThread().getName(), pTh.getSeatNeeded());
        }else{
            System.out.printf("Sorry sir %s, The number of seat requested %d are not available %n",
                    Thread.currentThread().getName(), pTh.getSeatNeeded());
        }
    }

    public synchronized boolean bookTickets(int seats, String name){
        System.out.println("Welcome. Seats available are " +totalSeatsAvailable);
        if(seats > totalSeatsAvailable){
            return false;
        }else{
            totalSeatsAvailable -= seats;
            return true;
        }
    }
}
