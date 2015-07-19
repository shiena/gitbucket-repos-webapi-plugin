name := "gitbucket-repos-webapi-plugin"

organization := "io.github.gitbucket-repos-webapi"

version := "0.0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
    "gitbucket" % "gitbucket-assembly" % "3.4.0" % "provided",
    "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

resolvers += "amateras-repo" at "http://amateras.sourceforge.jp/mvn"
