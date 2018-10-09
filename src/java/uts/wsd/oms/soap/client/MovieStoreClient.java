package uts.wsd.oms.soap.client;

import java.util.Scanner;

/**
 * A SOAP Client that allows access to the SOAP service through the command line
 */
public class MovieStoreClient {

    static final History_Service HISTORY_LOCATOR = new History_Service();
    static HistorySoap history = HISTORY_LOCATOR.getHistorySoapPort();
    static final PlaceOrder_Service ORDER_LOCATOR = new PlaceOrder_Service();
    static PlaceOrder order = ORDER_LOCATOR.getPlaceOrderPort();
    static Scanner in = new Scanner(System.in);

    /**
     * Print out a menu that allows the user to access the SOAP service
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------");
        PlaceOrder();
        System.out.println("-------------------------------------------------------------");
        ViewOrders();
    }

    /**
     * Prompt the user for order details to query and the display matching orders
     */
    private static void ViewOrders() {
        String email, id, title, status;
        System.out.println("Please provide the filter parameters, leave blank for all");
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enetr Order ID: ");
        id = in.nextLine();
        System.out.print("Enter Movie Title: ");
        title = in.nextLine();
        System.out.print("Enter Order status: ");
        status = in.nextLine();
        
        System.out.println("");
        for (Order order : history.viewAllOrders(id, email, title, status).getOrder()) {
            System.out.println("----------------------------------------------------");
            System.out.println(getOrderString(order));
        }
    }
    
    /**
     * Build a string for the order so that it can be printed
     * @param order
     * @return A string representing the contents of the order
     */
    private static String getOrderString(Order order) {
        String orderString = "Order ID: " + order.getOrderID() + "\n";
        orderString += "└ Movies:\n";
        for (Movie m : order.getMovies().getMovie()) {
            orderString += "└- Title: " + m.getTitle() + "\n";
            orderString += "└- Genre: " + m.getGenre() + "\n";
            orderString += "└- Release Year: " + m.getReleaseDate() + "\n";
            orderString += "└- Price: " + m.getPrice() + "\n";
            orderString += "└- Copies: " + m.getCopies() + "\n";
        }
        orderString += "└ Name: " + order.getFirstName() + " " + order.getLastName() + "\n";
        orderString += "└ Email: " + order.getEmail() + "\n";
        orderString += "└ Payment Method: " + order.getPaymentMethod() + "\n";
        orderString += "└ Sale Totale: $" + order.getSaleTotal() + "\n";
        orderString += "└ Order Status: " + order.getOrderStatus();
        return orderString;
    }
    
    private static void PlaceOrder() {
        String email, firstName, lastName, MovieTitle,releaseDate;
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enetr First Name: ");
        firstName = in.nextLine();
        System.out.print("Enter last Name: ");
        lastName = in.nextLine();
        Boolean AddMovies = true;
        while (AddMovies == true){
            String add = "y";
            System.out.print("What is the title of the Movie would you like to Buy");
            MovieTitle = in.nextLine();
            System.out.print("What is the releaseDate of the Movie would you like to Buy");
            releaseDate = in.nextLine();
            Movie movie = order.getMovie(MovieTitle, releaseDate );
            if (movie == null){
                System.out.println("Hey You need to enter a valid movie");
            }
            else { // Add another movie ?
                while (add != "n") {
                    System.out.print("Would you like to add another movie? (y/n)");
                    add = in.nextLine();
                    if (add != "y" | add != "n"){
                        System.out.print("Please enter a 'y' or an 'n'");
                    }
                    else if (add == "n"){
                        AddMovies = false;
                    }
                }
            }
        }

        System.out.println("Finalising your order");
        order.addOrder(email, firstName, lastName, movies);
    }
}
