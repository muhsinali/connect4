package controllers

import javax.inject._

import models.Game
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {
  private val game = new Game


  def index: Action[AnyContent] = Action {implicit request =>
    Ok(views.html.main(game.grid, game.currentPlayer))
  }

  def placeDisc(col: Int): Action[AnyContent] = Action {
    if(!game.placeDisc(col)){
      Redirect(routes.HomeController.index()).flashing("error" -> "Column is full. Please choose another one.")
    } else Redirect(routes.HomeController.index())
  }

}

