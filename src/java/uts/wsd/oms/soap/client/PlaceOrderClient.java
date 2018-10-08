/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap.client;

import java.util.Scanner;
import uts.wsd.oms.*;

/**
 *
 * @author caleb
 */
public class PlaceOrderClient {
    public static void main(String[] args) {
        
        PlaceOrder_Service locator = new PlaceOrder_Service();
        PlaceOrder order = locator.getPlaceOrderPort();
        
        Scanner in = new Scanner(System.in);
        String email, firstName, lastName, status;
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enetr First Name: ");
        firstName = in.nextLine();
        System.out.print("Enter last Name: ");
        lastName = in.nextLine();
        
        Movie movie = new Movie();
        System.out.println("-------------------------------------------------------------");
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
        
        System.out.println("Press enter to create the MOVIES");
        in.next();
        Movies movies = new Movies();
        
        System.out.println("Press enter to add the movie to the MOVIES");
        in.next();
        
        movies.movie.add(movies.movie.size(), movie);
        
        System.out.println("Press enter to finalise your order");
        in.next();
        order.addOrder(email, firstName, lastName, (uts.wsd.oms.soap.client.Movies) movies.movie);
    }
}
