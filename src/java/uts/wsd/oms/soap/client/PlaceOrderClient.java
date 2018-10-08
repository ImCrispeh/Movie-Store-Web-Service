/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap.client;

import java.util.Scanner;

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
        movie.setCopies(1);
        movie.setGenre("Action");
        movie.setPrice(20);
        movie.setReleaseDate(2018);
        movie.setTitle("Avengers Infinity War");
        Movies movies = new Movies();
        movies.movie.add(movies.movie.size(), movie);
        order.addOrder(email, firstName, lastName, movies);
    }
}
