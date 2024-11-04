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
    private var usableTool = ""
    private var discoverableItem = ""

    /**
     * Functions to add neighbours and items
     */
    fun addNorth(location: Location) {
        north = location
        location.south = this
    }

    fun addSouth(location: Location) {
        south = location
        location.north = this
    }

    fun addEast(location: Location) {
        east = location
        location.west = this
    }

    fun addWest(location: Location) {
        west = location
        location.east = this
    }

    fun addTool(tool: String) {
        this.usableTool = tool
    }

    fun removeTool() {
        this.usableTool = ""
    }

    fun addDiscoverableItem(item: String) {
        discoverableItem = item
    }

    fun getDiscoverableItem(): String {
        return discoverableItem
    }

    fun removeDiscoverableItem() {
        discoverableItem = ""
    }

    fun getUsableTool(): String {
        return usableTool
    }

    fun removeUsableTool() {
        usableTool = ""
    }

    fun hasTool(): Boolean {
        return usableTool.isNotEmpty()
    }

    fun hasItem(): Boolean {
        return discoverableItem.isNotEmpty()
    }
}