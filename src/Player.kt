/**
 * Player class
 */
class Player {
    // Properties to hold the player's inventory
    private val inventory = mutableListOf<String>()

    /**
     * Functions to interact with the player's inventory
     */
    fun addTool(tool: String) {
        inventory.add(tool)
    }

    fun hasTool(tool: String): Boolean {
        return inventory.contains(tool)
    }

    fun getInventory(): String {
        return inventory.joinToString(", ")
    }
}