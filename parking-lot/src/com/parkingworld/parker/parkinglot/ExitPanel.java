package com.parkingworld.parker.parkinglot;

import com.parkingworld.parker.items.Receipt;
import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.payment.CreditCard;
import com.parkingworld.parker.payment.PaymentProcessor;

public class ExitPanel {

  private PaymentProcessor paymentProcessor;

  public Receipt scanTicket(Ticket ticket) {
    return paymentProcessor.process(ticket);
  }

  public Receipt processPayment(Receipt receipt, String cash) {
    return  paymentProcessor.processPayment(receipt, cash);
  }

  public Receipt processPayment(Receipt receipt, CreditCard creditCard) {
    return  paymentProcessor.processPayment(receipt, "card");
  }
}
