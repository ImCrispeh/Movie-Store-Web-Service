package uts.wsd.oms.soap.client;

import java.util.Scanner;

public class MovieStoreClient {

    static Movie_Service movielocator = new Movie_Service();
    static MovieSoap movie = movielocator.getMovieSoapPort();
    static PlaceOrder_Service Orderlocator = new PlaceOrder_Service();
    static PlaceOrder order = Orderlocator.getPlaceOrderPort();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        AddMovie();
        System.out.println("-------------------------------------------------------------");
        PlaceOrder();
        System.out.println("-------------------------------------------------------------");
        ViewOrders();
    }

    private static void ViewOrders() {
        String email, id, title, status;
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enetr Order ID: ");
        id = in.nextLine();
        System.out.print("Enter Movie Title: ");
        title = in.nextLine();
        System.out.print("Enter Order status: ");
        status = in.nextLine();
        
        System.out.println("");
        for (Order order : movie.viewAllOrders(id, email, title, status).getOrder()) {
            System.out.println("----------------------------------------------------");
            System.out.println(getOrderString(order));
        }
    }

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
        String email, firstName, lastName, status;
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enetr First Name: ");
        firstName = in.nextLine();
        System.out.print("Enter last Name: ");
        lastName = in.nextLine();
        
        System.out.println("Finalising your order");
        order.addOrder(email, firstName, lastName, (uts.wsd.oms.soap.client.Movies) movies.movie);
    }
    public static void AddMovie(){
        Movie movie = new Movie();
        System.out.println("Please enter the details for the movie you would like to Buy: ");
        System.out.print("Enter the Title:");
        movie.setTitle(in.nextLine());
        System.out.print("Enter the Genre:");
        movie.setGenre(in.nextLine());
        System.out.print("Enter the release date of the movie:");
        movie.setReleaseDate(in.nextInt());
        System.out.print("Enter the amount of copies avalible:");
        movie.setCopies(in.nextInt());
        System.out.print("Enter the Price of each copie:");
        movie.setPrice(in.nextInt());
        
        Movies movies = new Movies();
        movies.movie.add(movies.movie.size(), movie);
    }
}
