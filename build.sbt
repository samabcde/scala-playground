ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .settings(
    name := "scala-playground",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4",
    // https://mvnrepository.com/artifact/org.apache.poi/poi
    libraryDependencies += "org.apache.poi" % "poi" % "5.3.0",
    // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
    libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.3.0",

    libraryDependencies +=
      "org.scalatestplus" %% "junit-5-10" % "3.2.18.0" % "test"
    ,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.18"
    ,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"
  )
