
name := "simple-http-server-json-postgresql-quill"
organization := "org.akka.templates"
version := "0.0.1"
scalaVersion := "2.12.2"

resolvers += Resolver.jcenterRepo

Revolver.enableDebugging(port = 5005, suspend = false)

enablePlugins(DockerPlugin)

dockerfile in docker := {
  // The assembly task generates a fat JAR file
  val artifact: File = assembly.value
  val artifactTargetPath = s"/app/${artifact.name}"

  new Dockerfile {
    from("java")
    add(artifact, artifactTargetPath)
    entryPoint("java", "-jar", artifactTargetPath)
  }
}

libraryDependencies += "com.wix" %% "accord-core" % "0.7.1"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.9"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.19"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "de.heikoseeberger" %% "akka-http-jackson" % "1.18.0"

libraryDependencies += "io.getquill" % "quill-sql_2.12" % "1.3.0"
libraryDependencies += "io.getquill" % "quill-async-postgres_2.12" % "1.3.0"

//test libraries
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.pegdown" % "pegdown" % "1.6.0" % "test"
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.0.9" % "test"
libraryDependencies += "ru.yandex.qatools.embed" % "postgresql-embedded" % "2.3" % "test"
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4" % "test"

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)
