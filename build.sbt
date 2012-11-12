/* basic project info */
name := "myproj"

organization := "com.example"

version := "0.1.0-SNAPSHOT"

description := "this project can foo a bar!"

homepage := Some(url("https://github.com/johndoe/myproj"))

startYear := Some(2012)

licenses := Seq(
  ("GPLv3", url("http://www.gnu.org/licenses/gpl-3.0.txt"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/johndoe/myproj"),
    "scm:git:https://github.com/johndoe/myproj.git",
    Some("scm:git:git@github.com:johndoe/myproj.git")
  )
)

// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.9.2"

// crossScalaVersions := Seq("2.9.1")

offline := false

scalacOptions ++= Seq("-deprecation", "-unchecked")

// scalacOptions ++= Seq("-Ydependent-method-types") // if using shapeless

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("com.example.myproj.Main")

mainClass in (Compile, run) := Some("com.example.myproj.Main")




// addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")

// scalacOptions += "-P:continuations:enable"



resolvers ++= Seq(
  "twitter4j" at "http://twitter4j.org/maven2"
)

libraryDependencies ++= Seq(
  "org.twitter4j" % "twitter4j-core" % "2.2.6-SNAPSHOT",
  "org.twitter4j" % "twitter4j-stream" % "2.2.6-SNAPSHOT",
  "net.debasishg" % "redisclient_2.9.2" % "2.6"
)


/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeIvyRepo("snapshots")
  // Resolver.typesafeIvyRepo("releases")
  // Resolver.typesafeRepo("releases")
  // Resolver.typesafeRepo("snapshots")
  // JavaNet2Repository,
  // JavaNet1Repository
)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
                      }

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>johnd</id>
      <name>John Doe</name>
      <email>john.doe@example.com</email>
      <!-- <url></url> -->
    </developer>
  </developers>
)

// Josh Suereth's step-by-step guide to publishing on sonatype
// httpcom://www.scala-sbt.org/using_sonatype.html

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("com.example.myproj.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
