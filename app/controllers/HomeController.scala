package controllers

import javax.inject._

import models.{Disc, Game}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {
  private val game = new Game


  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index: Action[AnyContent] = Action {
    Ok(views.html.main(game.grid))
  }

  def placeDisc(col: Int): Action[AnyContent] = Action {
    game.grid.placeDisc(col, Disc.RED)
    Redirect(routes.HomeController.index())
  }

}

