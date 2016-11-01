package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.application.push.TopicKey;
import org.richfaces.application.push.TopicsContext;

/**
 * @author <a href="http://community.jboss.org/people/lfryc">Lukas Fryc</a>
 */
@ManagedBean(name = "pushBean")
@ViewScoped
public class PushBean {

	
	public Date getDate() {
		return new Date();
	}
 
	public void push() throws Exception {
		TopicKey topicKey = new TopicKey("pushTopicsContext");
		TopicsContext topicsContext = TopicsContext.lookup();
  
		topicsContext.publish(topicKey, "empty message");
  
		System.out.println("push event");
	}

    @PostConstruct
    public void postContruct() {
    }

   
}