import java.sql.*;

public class TicketController {

    String url = "jdbc:mysql://localhost:3306/tickets";
    String user = "root";
    String password = "root051038";


    public void uploadTicket(Ticket ticket){
        String sql = "INSERT INTO tickets (id,title,price,qty) VALUES (?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setString(2, ticket.getTitle());
            preparedStatement.setInt(3, ticket.getPrice());
            preparedStatement.setInt(4, ticket.getQuantity());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateTicket(int eventId, String updatedTitle, int updatedPrice, int updatedQuantity) {
        String sql = "UPDATE tickets SET title = ?, price = ?, qty = ? WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedTitle);
            preparedStatement.setInt(2, updatedPrice);
            preparedStatement.setInt(3, updatedQuantity);
            preparedStatement.setInt(4, eventId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Ticket updated successfully!");
            } else {
                System.out.println("No ticket found with the given ID.");
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void showAvailableTickets() {
        String sql = "SELECT * FROM tickets";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            int eventId ;
            String eventTitle;
            int eventPrice;
            int availableTickets;

            while(result.next()){
                eventId = result.getInt("id");
                eventTitle = result.getString("title");
                eventPrice = result.getInt("price");
                availableTickets = result.getInt("qty");
                System.out.println("Event ID: "+ eventId+  " Event Title: "+eventTitle+" Ticket Price: " +eventPrice+" Available Tickets: "+availableTickets);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void buyTicket(int eventId) {
        String sql = "UPDATE tickets SET qty = qty - 1 WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();


        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
