package com.bookmyshow.users;


import com.bookmyshow.BMSService;
import com.bookmyshow.model.Show;

public class LoggedUser extends SystemMember {

    private BMSService bmsService;

    public void selectCity() {
        bmsService.selectCity("Nagpur");
    }

    public Ticket createBooking(Show show) {
        bmsService.bookTicket();
    };
}
