package io.inspire.springFramework;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
//@Service
//@Repository
@Controller
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;

	@Autowired
	private MessageSource messageSource;

	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void draw() {
		System.out.println(this.messageSource.getMessage("draw.circle", null, "Default Greeting", null));
		System.out.println(this.messageSource.getMessage("draw.point", new Object[] { center.getX(), center.getY() },
				"Default Greeting", null));
		// System.out.println("Center Point X: " + center.getX() + ", Y: " +
		// center.getY());
		System.out.println("From Child: " + this.messageSource.getMessage("greeting", null, "Default Greeting", null));
		DrawEvent d = new DrawEvent(this);
		publisher.publishEvent(d);
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	// @Autowired
	// @Qualifier("circleRelated")
	@Resource(name = "pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init the Circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy the Circle");
	}
}
