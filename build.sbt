name := """scala-mail"""

organization := "ch.taggiasco"

version := "0.0.1"

scalaVersion := "2.12.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  Seq(
    "javax.mail"         %  "mail"                    % "1.4",
    "org.scalatest"      %% "scalatest"               % "3.0.1"     % "test"
  )
}
