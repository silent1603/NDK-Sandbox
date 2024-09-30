# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

cmake_minimum_required(VERSION 3.22.1)

project("game_engine")

# Creates your game shared library. The name must be the same as the
# one used for loading in your Kotlin/Java or AndroidManifest.txt files.
add_library(game_engine SHARED
        main.cpp
        AndroidOut.cpp
)

# Searches for a package provided by the game activity dependency
find_package(oboe REQUIRED CONFIG)
find_package(game-activity REQUIRED CONFIG)
find_package(games-controller REQUIRED CONFIG)
find_package(games-frame-pacing REQUIRED CONFIG)
find_package(games-performance-tuner REQUIRED CONFIG)
find_package(com.google.android.gms.gni.c REQUIRED CONFIG)

# Configure libraries CMake uses to link your target library.
target_link_libraries(game_engine
        # The game activity
        game-activity::game-activity
        # EGL and other dependent libraries required for drawing
        # and interacting with Android system
        jnigraphics
        vulkan
        com.google.android.gms.gni.c::gni_shared
        android
        atomic
        EGL
        game-activity::game-activity_static
        oboe::oboe
        games-controller::paddleboat_static
        games-frame-pacing::swappy_static
        games-performance-tuner::tuningfork_static
        GLESv3
        log)