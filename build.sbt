// SMRC begin clarifi
organization := "clarifi"

publishMavenStyle := false

version := { ("git rev-parse HEAD" !!).trim }

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false
// SMRC end clarifi

name := "machines"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.0-RC1"

libraryDependencies += "org.scalaz" %% "scalaz-effect" % "7.0.0-RC1"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.2", "2.10.1")

scalacOptions ++= Seq("-deprecation", "-unchecked")

scalacOptions <++= scalaVersion map {
  case sv if sv.contains("2.10") =>
    Seq("-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-language:postfixOps")
  case _ =>
    Seq("-Ydependent-method-types")
}
