/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;

public class UserController implements Serializable {

    private String filePath;
    private Users users;

    public UserController() {
        // TODO Auto-generated constructor stub
    }

    public UserController(String filePath, Users users) {
        super();
        this.filePath = filePath;
        this.users = users;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws Exception {

        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller u = jc.createUnmarshaller();

        this.filePath = filePath;
        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        users = (Users) u.unmarshal(fin); // This loads the "shop" object		
        fin.close();

    }

    public void updateXML(Users users, String filePath) throws Exception {
        this.users = users;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users, fout);
        fout.close();
    }
    // For the advanced step, you might consider adding a saveStudents() method here
    // to be used from the welcome.jsp page

    public void saveUsers() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users, fout);
        fout.close();
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public void editUser(User user, String firstName, String lastName, String password, String address, String phoneNo) throws Exception{
        users.removeUser(user);
        user.updateUser(firstName, lastName, password, address, phoneNo);
        users.addUser(user);
        updateXML(users,filePath);
    }

}