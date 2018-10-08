/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap;

import java.io.IOException;
import javax.annotation.Resource;
import javax.jws.*;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.oms.*;

/**
 *
 * @author caleb
 */
@WebService(serviceName = "PlaceOrder")
public class PlaceOrder {
    
    @Resource
    private WebServiceContext context;

    private MovieStoreApplication getMovieStoreApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        MovieStoreApplication movieStoreApp = (MovieStoreApplication) application.getAttribute("diaryApp");
        try {
            if (movieStoreApp == null) {
                movieStoreApp = new MovieStoreApplication();
                movieStoreApp.setFilePath(application.getRealPath("WEB-INF"));
                application.setAttribute("movieStoreApp", movieStoreApp);
            }
        } catch (JAXBException | IOException ex) {
        }
        return movieStoreApp;
    }

    /**
     *
     * @param email
     * @param firstName
     * @param lastName
     * @param movies
     */
    @WebMethod()
    public void AddOrder(@WebParam(name="email") String email, @WebParam(name="firstName") String firstName, @WebParam(name="lastName") String lastName, @WebParam(name="movies") Movies movies ) {
        Order order = new Order();
        order.setEmail(email);
        order.setFirstName(firstName);
        order.setLastName(lastName);
    }
}

