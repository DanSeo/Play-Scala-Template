package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import scalikejdbc._
import storage.RedisStorage

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() (redisStorage: RedisStorage) extends Controller {
  implicit val session = AutoSession
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val id = 1
    val playProject = sql"SELECT id, name, version FROM project WHERE id = ${id}".map {
      rs =>
        (rs.long("id"), rs.string("name"), rs.string("version"))
    }.single().apply()

    playProject.foreach { s =>
      Logger.info(s"id:${s._1},name:${s._2},version:${s._3}")

      if (redisStorage.set(s._2, s._3) ){
        Logger.info(s"redis cachced set : ${redisStorage.get(s._2).getOrElse("1.0.0")}")
      }

    }


    Ok("Ok")
  }

}
