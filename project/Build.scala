import sbt._
import Keys._

object ApplicationBuild extends Build {

    val appName         = "Inventory Control"
    val appVersion      = "1.0"

    val appDependencies = Seq(
        "mysql" % "mysql-connector-java" % "5.1.26",
        "com.typesafe" %% "play-plugins-mailer" % "2.0.4",
        "org.scala-tools" %% "scala-stm" % "0.3",
        "org.apache.derby" % "derby" % "10.4.1.3" % "test"      
    )
}