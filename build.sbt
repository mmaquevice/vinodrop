name := "vinodrop"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings

 lessEntryPoints <<= baseDirectory(_ / "app" / "assets" / "ace" / "css" ** "ace.less")
