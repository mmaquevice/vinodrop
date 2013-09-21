import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Override
	public void onStart(Application app) {
		ctx.start();
	}

	@Override
	public void onStop(Application app) {
		Neo4jTemplate neoTemplate = ctx.getBean(Neo4jTemplate.class);
		neoTemplate.getGraphDatabaseService().shutdown();
		ctx.stop();
	}

	@Override
	public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
		return ctx.getBean(controllerClass);
	}

}
