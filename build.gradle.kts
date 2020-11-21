plugins {
    kotlin("jvm") version "1.3.72"

    id("com.bmuschko.docker-java-application") version "6.6.1"


}

repositories {
    jcenter()
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // comment kotlin-reflect and you have error!!!!
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect", version = "1.3.72")

}


docker{
   javaApplication{
       baseImage.set("openjdk:11-alpine")
       images.set(setOf("docker-internal.ru/bpm/JiraHelper"))
   }
}

tasks.build{
    dependsOn(tasks.dockerBuildImage)
}
