name := "simple-http-server-json"
version := "0.0.1"
scalaVersion := "2.12.2"

resolvers += Resolver.jcenterRepo
resolvers += "Scala Validation Releases" at "http://dl.bintray.com/scala-validation/releases"

libraryDependencies += "org.scala.validation" %% "core" % "0.0.5"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.9"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.19"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.8"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.8"

libraryDependencies += "org.scalikejdbc" %% "scalikejdbc" % "3.0.2"

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"

//test libraries
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.pegdown" % "pegdown" % "1.6.0" % "test"
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.0.9" % "test"
libraryDependencies += "ru.yandex.qatools.embed" % "postgresql-embedded" % "2.3" % "test"

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)
