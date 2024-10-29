package com.example.class06filterlistener.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextListener implements ServletContextListener , HttpSessionListener , HttpSessionAttributeListener {
    private static Map<String, Object> sessionMap;

    public ContextListener() {

    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextListener 初始化");
        sessionMap = new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextListener 销毁");
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        sessionMap.remove(session.getId());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated,创建了会话");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed,销毁了会话");
    }
}
