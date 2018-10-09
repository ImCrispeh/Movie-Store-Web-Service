package uts.wsd.oms;

import java.io.Serializable;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
@XmlType(namespace="http://uts/wsd/oms")
public class User implements Serializable {

    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "phoneNo")
    private String phoneNo;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "state")
    private String state;
    @XmlElement(name = "postCode")
    private String postCode;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String phoneNo, String address, String city, String state, String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public void updateUser(String firstName, String lastName, String password, String address, String phoneNo){
        this.firstName = firstName;
        this.lastName= lastName;
        this.password = password;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}

