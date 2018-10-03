package uts.wsd.oms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    @XmlElement(name = "orderID")
    private int orderID;

    @XmlElement(name = "movies")
    private Movies movies;

    @XmlElement(name = "firstName")
    private String firstName;
    
    @XmlElement(name = "lastName")
    private String lastName;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "paymentMethod")
    private String paymentMethod;

    @XmlElement(name = "saleTotal")
    private int saleTotal;

    @XmlElement(name = "orderStatus")
    private String orderStatus;

    public Order() {
    }

    public Order(int orderID, Movies movies, String firstName, String lastName, String email, String paymentMethod, int saleTotal, String orderStatus) {
        this.orderID = orderID;
        this.movies = movies;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.saleTotal = saleTotal;
        this.orderStatus = orderStatus;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(int saleTotal) {
        this.saleTotal = saleTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    private void updateTotal(){
        saleTotal = 0;
        for(Movie movie : movies.getList())
            saleTotal += movie.getCopies() * movie.getPrice();
    }
    
    public void addMovie(Movie movie){
        movies.addMovie(movie);
        updateTotal();
    }
    
    public void removeMovie(Movie movie){
        movies.removeMovie(movie);
        updateTotal();
    }
    
    public void removeMovie(String title, String releaseDate){
        movies.removeMovie(title, releaseDate);
        updateTotal();
    }
}
