package rpsls

import scala.util.Random

import model._
import Move._
import Outcome._
import java.{util => ju}
import scala.concurrent.Future

trait GameService {
  def makePlay(playerMove: Move): Future[Int]
  def getResult(id: Int): Future[Either[ApiError, Game]]
}

class GameServiceImpl(repo: GameRepo) extends GameService {

  override def makePlay(playerMove: Move): Future[Int] = {
    val botMove = generateBotMove()
    val outcome = calculateOutcome(playerMove, botMove)
    repo.write(Game(playerMove, botMove, outcome))
  }

  override def getResult(id: Int): Future[Either[ApiError, Game]] = {
    repo.read(id)
  }

  private def generateBotMove(): Move = {
    Random.shuffle(Move.values.toList).head
  }

  private def calculateOutcome(playerMove: Move, botMove: Move): Outcome = {
    (playerMove, botMove) match {
      case (playerMove, botMove) if playerMove == botMove => Draw
      case (Rock, Scissors) | (Scissors, Paper) | (Paper, Rock) |
          (Rock, Lizard) | (Scissors, Lizard) | (Paper, Spock) |
          (Lizard, Paper) | (Lizard, Spock) | (Spock, Rock) |
          (Spock, Scissors) =>
        Win
      case _ => Lose
    }
  }

}
