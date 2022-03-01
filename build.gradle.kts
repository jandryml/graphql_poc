import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.lombok") version "1.6.10"
    id("io.freefair.lombok") version "5.3.0"
}

group = "cz.edu.dryml"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val graphQLLibVersion = "5.7.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")
//    implementation("com.graphql-java:graphql-java-tools:5.2.4")

    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Latest graphQL support
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:${graphQLLibVersion}")
    implementation ("com.graphql-java-kickstart:graphql-java-tools:5.5.2")
    implementation ("com.graphql-java:graphql-java-extended-scalars:1.0")
    runtimeOnly("com.graphql-java-kickstart:graphiql-spring-boot-starter:${graphQLLibVersion}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
