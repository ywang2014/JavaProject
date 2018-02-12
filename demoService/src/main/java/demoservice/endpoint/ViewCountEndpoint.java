package demoservice.endpoint;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class ViewCountEndpoint extends AbstractEndpoint<ViewCount>{
	public ViewCountEndpoint() {
		super("viewcount");
	}
	
	@Override
	public ViewCount invoke() {
		return ViewCount.newInstance();
	}
}
