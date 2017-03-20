package controllers

import javax.inject._

import models.{Disc, Grid}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val grid = new Grid
    grid.placeDisc(1, Disc.RED)
    grid.placeDisc(1, Disc.YELLOW)
    grid.placeDisc(5, Disc.YELLOW)
    Ok(views.html.main(grid))
  }

}
