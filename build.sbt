import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
      name := "rpsls",
      resolvers += Resolver.bintrayRepo("buildo", "maven"),
      libraryDependencies ++= Seq(
        "io.buildo" %% "enumero" % "1.2.1",
        "io.buildo" %% "enumero-circe-support" % "1.2.1",
        "com.typesafe.akka" %% "akka-http" % "10.0.10",
        "de.heikoseeberger" %% "akka-http-circe" % "1.18.0",
        "io.circe" %% "circe-core" % "0.8.0",
        "io.circe" %% "circe-generic" % "0.8.0",
        "io.buildo" %% "wiro-http-server" % "0.5.2",
        "org.slf4j" % "slf4j-nop" % "1.6.4"
      ),
      addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  )

// Uncomment the following for publishing to Sonatype.
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for more detail.

// ThisBuild / description := "Some descripiton about your project."
// ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
// ThisBuild / homepage    := Some(url("https://github.com/example/project"))
// ThisBuild / scmInfo := Some(
//   ScmInfo(
//     url("https://github.com/your-account/your-project"),
//     "scm:git@github.com:your-account/your-project.git"
//   )
// )
// ThisBuild / developers := List(
//   Developer(
//     id    = "Your identifier",
//     name  = "Your Name",
//     email = "your@email",
//     url   = url("http://your.url")
//   )
// )
// ThisBuild / pomIncludeRepository := { _ => false }
// ThisBuild / publishTo := {
//   val nexus = "https://oss.sonatype.org/"
//   if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//   else Some("releases" at nexus + "service/local/staging/deploy/maven2")
// }
// ThisBuild / publishMavenStyle := true
