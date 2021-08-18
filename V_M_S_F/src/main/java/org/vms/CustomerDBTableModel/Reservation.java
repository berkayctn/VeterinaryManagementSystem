package org.vms.CustomerDBTableModel;

public class Reservation {
    private String reservationCustomerId;
    private String reservationDate;



    public Reservation( String reservationCustomerId,String reservationDate) {
        this.reservationCustomerId = reservationCustomerId;
        this.reservationDate = reservationDate;

    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

   public String getReservationCustomerId() {
        return reservationCustomerId;
    }

    public void setReservationCustomerId(String reservationCustomerId) {
        this.reservationCustomerId = reservationCustomerId;
    }
}
