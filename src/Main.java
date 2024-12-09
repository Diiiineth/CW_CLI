import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Ticket ticket = new Ticket(000,"lft",1000,50);
        TicketController ticketController = new TicketController();
//        ticketController.uploadTicket(ticket);


//        int eventId =1;
//        String updatedTitle = "updated";
//        int updatedPrice = 8000;
//        int updatedQuantity = 20;
//        ticketController.updateTicket(ticketId,updatedTitle,updatedPrice,updatedQuantity);

//        ticketController.showAvailableTickets();

        int eventId = 1;
        ticketController.buyTicket(eventId);
    }

}