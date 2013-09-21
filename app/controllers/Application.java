package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import play.*;
import play.mvc.*;
import services.GalaxyService;
import views.html.*;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	static GalaxyService galaxyService;

	public static Result index() {
		if (galaxyService.getNumberOfWorlds() == 0) {
			galaxyService.makeSomeWorldsAndRelations();
		}

		// def allWorlds: List[World] = galaxyService.getAllWorlds()
		// def first: World = allWorlds.get(0)
		// def last: World = allWorlds.get(allWorlds.size() - 1)
		// def pathFromFirstToLast: List[World] =
		// galaxyService.getWorldPath(first, last)

		return ok(index.render("Your new application is ready."));
	}
}
