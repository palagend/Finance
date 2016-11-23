package com.palagend.listener; /**
 * Created by palagend on 2016/11/24.
 */

import sun.util.logging.PlatformLogger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.logging.Logger;

public class OnlineCountListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private int currOnlineCount = 0;
    private  static Logger log = Logger.getLogger(OnlineCountListener.class.getCanonicalName());

    // Public constructor is required by servlet spec
    public OnlineCountListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        this.currOnlineCount++;
        se.getSession().setAttribute("currOnlineCount", currOnlineCount);
        log.info("上线成功,当前在线人数:" + currOnlineCount);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        this.currOnlineCount--;
        se.getSession().setAttribute("currOnlineCount", currOnlineCount);
        log.info("下线成功,当前在线人数:" + currOnlineCount);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        sbe.getSession().getServletContext().setAttribute("currOnlineCount", sbe.getSession().getAttribute("currOnlineCount"));
        log.info("在线人数发生变动,当前在线人数是:"+sbe.getSession().getServletContext().getAttribute("currOnlineCount"));
    }
}
