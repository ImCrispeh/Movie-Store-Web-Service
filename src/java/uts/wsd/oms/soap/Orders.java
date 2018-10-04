/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.*;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.oms.*;

/**
 *
 * @author MKs
 */
@WebService(serviceName = "Orders")
public class Orders {

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
        } catch (JAXBException ex) {
        } catch (IOException ex) {
        }
        return movieStoreApp;
    }
    
    @WebMethod()
    public History ViewAllOrder(){
        return getMovieStoreApp().getHistory();
    }
}
