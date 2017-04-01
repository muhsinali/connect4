package controllers

import javax.inject._

import models.Game
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

/*
 * HomeController handles all requests from the user and contains all entry points to this web app.
 * */
@Singleton
class HomeController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {
  private var game = new Game


  def index(): Action[AnyContent] = Action {implicit request =>
    if(game.hasBeenWon){
      game = new Game
    }
    Ok(views.html.main(game.grid, game.currentPlayer))
  }

  def placeDisc(col: Int): Action[AnyContent] = Action {
    if(game.placeDisc(col)){
      if(game.hasBeenWon) Redirect(routes.HomeController.gameOver())
      else {
        game.nextPlayer()
        Redirect(routes.HomeController.index())
      }
    } else Redirect(routes.HomeController.index()).flashing("error" -> "Column is full. Please choose another one.")
  }

  def gameOver(): Action[AnyContent] = Action {Ok(views.html.gameOver(game.currentPlayer))}

  def notFound(): Action[AnyContent] = Action{Ok(views.html.notFound())}
}

