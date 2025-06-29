plugins {
    id("java")
}

group = "de.dergamer09"
version = "1.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.opencollab.dev/main/") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Falls du keine Multi-Projekte verwendest, entferne diese Zeilen:
    // implementation(project(":common"))
    // compileOnly(project(":common:loader-utils"))

    compileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
