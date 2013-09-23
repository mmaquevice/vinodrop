package controllers;

import java.util.List;

import models.World;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import play.*;
import play.Logger.ALogger;
import play.mvc.*;
import services.GalaxyService;
import views.html.*;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	ALogger log = Logger.of(Application.class);

	@Autowired
	GalaxyService galaxyService;

	public Result index() {
		if (galaxyService.getNumberOfWorlds() == 0) {
			galaxyService.makeSomeWorldsAndRelations();
		}

		List<World> worlds = galaxyService.getAllWorlds();
		World first = worlds.get(0);
		World last = worlds.get(worlds.size() - 1);
		List<World> pathWorlds = galaxyService.getWorldPath(first, last);

		log.info("toto");

		return ok(index.render("Your new application is ready."));
	}
}
