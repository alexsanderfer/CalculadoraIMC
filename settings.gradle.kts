/*
 * Copyright (c) 2024. Created by Alexsander Fernandes at 1/3. All rights reserved.
 * GitHub: https://github.com/alexsanderfer/
 * Portfolio: https://alexsanderfer.netlify.app/
 */

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CalculadoraIMC"
include(":app")
