/**
 * Player class
 */
class Player {
    // Properties to hold the player's inventory
    private val inventory = mutableListOf<String>()

    /**
     * Functions to interact with the player's inventory
     */
    fun hasItem(item: String): Boolean {
        return inventory.contains(item)
    }

    fun addItem(item: String) {
        inventory.add(item)
    }

    fun removeItem(item: String) {
        inventory.remove(item)
    }

    fun getInventory(): String {
        return inventory.joinToString(", ")
    }
}