package org.inspire.aop.service;

import org.inspire.aop.aspect.XmlAspect;
import org.inspire.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new XmlAspect().loggingAdvice();
		return super.getCircle();
	}
}
