package io.inspireinnovations.springconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	public GreetingController() {
	}

	@Value("${app.description: testing}")
	private String defaultGreetingMessage;

	@Value("${app.description}")
	private String greetingMessage;

	@Value("${my.list.values}")
	private List<String> listValues;

//	@Value("#{${dbValues}}")
//	private Map<String, String> dbValue;

	private String space = " ";

	@Autowired
	private DbSettings dbSetting;

	@Autowired
	private Environment env;

	@GetMapping("/greeting")
	public String greeting() {
//		return greetingMessage + space + listValues.get(0) + space + dbSetting.getConnection() + space
//				+ dbSetting.getPort();
		return greetingMessage;
	}

	@GetMapping("/envDetails")
	public String envDetails() {
		return env.toString();
	}
}
