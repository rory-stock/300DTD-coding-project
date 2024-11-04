/**
 * ------------------------------------------------------------------------
 * A Dark Forest
 * Level 3 programming project
 *
 * by Rory Stock
 *
 * This is a simple button-based game where the player can move around a grid of locations, pick up items and use them to discover other items.
 * The player can move north, south, east or west, and once they have the correct tools they can unlock new areas and progress through the game.
 * ------------------------------------------------------------------------
 */

import com.formdev.flatlaf.FlatLightLaf

//=============================================================================================

/**
 * Launch the application
 */
fun main() {
    // Flat, Dark look-and-feel
    FlatLightLaf.setup()

    // Create the UI
    GUI()
}


