package controllers;

import java.util.List;

import models.World;

import org.springframework.beans.factory.annotation.Autowired;

import play.*;
import play.mvc.*;
import services.GalaxyService;
import views.html.*;

@org.springframework.stereotype.Controller
public class Application extends Controller {

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

		return ok(index.render("Your new application is ready."));
	}
}
