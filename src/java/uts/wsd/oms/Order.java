package uts.wsd.oms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    @XmlElement(name = "orderId")
    private int orderID;

    @XmlElement(name = "movies")
    private Movies movies;

    @XmlElement(name = "fullName")
    private String fullname;

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

    public Order(Movies movies, String fullname, String email, String paymentMethod, int saleTotal, String orderStatus) {
        this.orderID = Util.generateOrderID();
        this.movies = movies;
        this.fullname = fullname;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
}
