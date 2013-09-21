name := "vinodrop"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaCore,
  "javax.inject" % "javax.inject" % "1",
  "asm" % "asm" % "3.3.1",
  "org.springframework" % "spring-context" % "3.2.2.RELEASE",
  "org.springframework.data" % "spring-data-neo4j" % "2.2.0.RELEASE",
  "org.springframework.data" % "spring-data-neo4j-rest" % "2.2.0.RELEASE" excludeAll(
      ExclusionRule(organization = "org.neo4j", name="neo4j")
    ),
  "org.neo4j" % "neo4j" % "1.9.RC1" excludeAll(
      ExclusionRule(organization = "org.neo4j", name="neo4j-kernel")
    ),
  "org.neo4j" % "neo4j-kernel" % "1.9.RC1" % "test" classifier "tests" classifier "",
  "org.neo4j" % "neo4j-rest-graphdb" % "1.9.M04"
)     

play.Project.playJavaSettings

lessEntryPoints <<= baseDirectory(_ / "app" / "assets" / "ace" / "css" ** "ace.less")

resolvers += "Spring releases" at "http://repo.springsource.org/release"

resolvers += "Spring Data snapshot" at "http://repo.springsource.org/snapshot/"

resolvers += "Neo4j" at "http://m2.neo4j.org/content/repositories/releases/"