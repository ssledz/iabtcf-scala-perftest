name := "iabtcf-scala-perftest"

organization := "io.github.ssledz"

scalaVersion := "2.13.1"

version := "0.0.1-SNAPSHOT"

resolvers += Resolver.mavenLocal

val iabtcfScala = "io.github.ssledz" %% "iabtcf-scala" % "0.0.0-35-546d55df-20200325-2256"

val iabtcfJava = "com.iabtcf" % "iabtcf-core" % "2.0.1-alpha.0-SNAPSHOT"

libraryDependencies ++= Seq(iabtcfScala, iabtcfJava)

val homeDir = sys.env.get("HOME").get
val JFRDir = "/tmp/profile-jfr"
val flameGraphDir= s"$homeDir/git/FlameGraph"
val jfrFlameGraphDir = s"$homeDir/bin/jfr-flame-graph/bin"

addCommandAlias("profTCStringParserBench", s"jmh:run TCStringParserBench -prof jmh.extras.JFR:dir=$JFRDir;flameGraphDir=$flameGraphDir;;jfrFlameGraphDir=$jfrFlameGraphDir;flameGraphOpts=--minwidth,2;verbose=true")

enablePlugins(JmhPlugin)