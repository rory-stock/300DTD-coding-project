/**
 * Location class
 */
class Location(val name: String) {
    // Properties to hold the location's neighbours
    var north: Location? = null
    var south: Location? = null
    var east: Location? = null
    var west: Location? = null

    // Properties to hold the location's message and item
    var message: String = ""
    var itemMessage: String = ""
    private var requiredItem: Item? = null
    private var discoverableItem: Item? = null

    /**
     * Functions to add neighbours and items
     */
    fun addNorth(location: Location) {
        north = location
        location.south = this
    }

    fun addEast(location: Location) {
        east = location
        location.west = this
    }

    fun addWest(location: Location) {
        west = location
        location.east = this
    }

    fun addRequiredItem(item: Item) {
        requiredItem = item
    }

    fun hasRequiredItem(): Boolean {
        return requiredItem != null
    }

    fun removeRequiredItem() {
        requiredItem = null
    }

    fun addDiscoverableItem(item: Item) {
        discoverableItem = item
        itemMessage = discoverableItem?.message ?: ""
    }

    fun hasItem(): Boolean {
        return discoverableItem != null
    }

    fun getItem(): Item? {
        return discoverableItem
    }

    fun removeDiscoverableItem() {
        discoverableItem = null
        itemMessage = ""
    }

    fun requiredItem(): Item? {
        return requiredItem
    }
}