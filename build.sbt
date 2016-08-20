name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalikejdbc" %% "scalikejdbc"                  % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-config"           % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "2.5.1",
  "mysql" % "mysql-connector-java" % "5.1.27",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.7",
  "net.debasishg" %% "redisclient" % "3.0",
  "net.logstash.logback" % "logstash-logback-encoder" % "4.7",
  "net.debasishg" %% "redisclient" % "3.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.scalikejdbc" %% "scalikejdbc-test"   % "2.4.2"   % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


fork in run := true
