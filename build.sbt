organization := "com.gilt"

name := "lib-lucene-sugar"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

libraryDependencies ++= Seq(
    "com.google.code.findbugs" % "jsr305" % "2.0.1",
    "com.google.guava" % "guava" % "14.0.1",
    "org.apache.lucene" % "lucene-core" % "4.3.0",
    "org.apache.lucene" % "lucene-analyzers-common" % "4.3.0",
    "org.apache.lucene" % "lucene-queryparser" % "4.3.0",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test",
    "org.mockito" % "mockito-all" % "1.9.0" % "test"
)

resolvers ++= Seq(
  "Sonatype.org Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype.org Releases" at "http://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "/service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://github.com/gilt/lib-lucene-sugar"))

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:gilt/lib-lucene-sugar.git</url>
    <connection>scm:git:git@github.com:gilt/lib-lucene-sugar.git</connection>
  </scm>
  <developers>
    <developer>
      <id>cloudify</id>
      <name>Federico Feroldi</name>
      <url>http://federicoferoldi.it/</url>
    </developer>
  </developers>)
