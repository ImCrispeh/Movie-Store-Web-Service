/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap;

import java.io.IOException;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.oms.*;

/**
 *
 * @author Zhong
 */
@WebService(serviceName = "LoginSoap")
public class LoginSoap {

    @Resource
    private WebServiceContext context;

    private MovieStoreApplication getMovieStoreApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        MovieStoreApplication movieStoreApp = (MovieStoreApplication) application.getAttribute("movieStoreApp");
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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public User Login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return getMovieStoreApp().getUsers().login(email, password);
    }
}
