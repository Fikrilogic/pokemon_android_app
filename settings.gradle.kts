pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "Pokemon Apps"
include(":app")
include(":commons:theme")
include(":commons:provider")
include(":commons:component")
include(":library:framework")
include(":library:jetframework")
include(":data:local")
include(":data:model")
include(":data:repository")
include(":domain")
include(":data:remote")
include(":feature:home")
include(":feature:splashscreen")
include(":feature:detail")
