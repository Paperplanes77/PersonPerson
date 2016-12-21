package listener;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import javafx.beans.binding.StringBinding;

/**
 * Application Lifecycle Listener implementation class OnlineUserList
 *
 */
@WebListener
public class OnlineUserList implements HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {
	private ServletContext app=null;
    /**
     * Default constructor. 
     */
    public OnlineUserList() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent paramHttpSessionEvent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent)  { 
         // TODO Auto-generated method stub
    	Set all=(Set)this.app.getAttribute("online");
    	if (all.size()>0) {
    		all.remove(paramHttpSessionEvent.getSession().getAttribute("online"));
		}
    	this.app.setAttribute("online", all);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         // TODO Auto-generated method stub
    	Set all=(Set)this.app.getAttribute("online");
    	String name=null;
    	String uname=(String)paramHttpSessionBindingEvent.getValue();
    	/*try {
			name = new String(uname.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		all.add(uname);
    	this.app.setAttribute("online",all);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         // TODO Auto-generated method stub
    	Set all=(Set)this.app.getAttribute("online");
    	all.remove(paramHttpSessionBindingEvent.getValue());
    	this.app.setAttribute("online", all);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent paramServletContextEvent)  { 
         // TODO Auto-generated method stub
    	this.app=paramServletContextEvent.getServletContext();
    	this.app.setAttribute("online", new TreeSet<>());
    }
	
}
