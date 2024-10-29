/**
 * ------------------------------------------------------------------------
 * Rory Stock 300DTD Kotlin Coding Project
 * Level 3 programming project
 *
 * by Rory Stock
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */


import com.formdev.flatlaf.FlatLightLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


//=============================================================================================

/**
 * Location class
 */
class Location(val name: String) {
    // Properties to hold the location's neighbours
    var north: Location? = null
    var south: Location? = null
    var east: Location? = null
    var west: Location? = null

    // Properties to hold the location's message and items
    var message: String = ""
    var items: MutableList<String> = mutableListOf()

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

    fun addItem(item: String) {
        items.add(item)
    }

    fun removeItem(item: String) {
        items.remove(item)
    }
}


/**
 * GUI class
 * Defines the UI and responds to events
 */
class GUI : JFrame(), ActionListener {

    // Data store
    private val location = mutableListOf<Location>()
    private var currentLocation: Location

    // Setup labels to display the current location and location information
    private lateinit var locationLabel: JLabel
    private lateinit var messageLabel: JLabel
    private lateinit var inventoryLabel: JLabel

    // Setup buttons to move between locations
    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton

    /**
     * Create, build and run the UI
     */
    init {
        setupLocations()
        setupWindow()
        buildUI()

        // Show the app, centred on screen
        setLocationRelativeTo(null)
        isVisible = true

        // Set the starting location
        currentLocation = location[0]
        showLocation()
    }

    private fun setupLocations() {
        // Create the locations
        val location1 = Location("Location 1")
        val location2 = Location("Location 2")
        val location3 = Location("Location 3")
        val location4 = Location("Location 4")
        val location5 = Location("Location 5")
        val location6 = Location("Location 6")
        val location7 = Location("Location 7")
        val location8 = Location("Location 8")
        val location9 = Location("Location 9")
        val location10 = Location("Location 10")

        /**
         * Configure the locations
         */
        location1.addNorth(location2)
        location1.addEast(location3)
        location1.addItem("Sword")
        location1.message = "You are in a dark forest. You see a sword on the ground."

        location2.addSouth(location1)
        location2.addEast(location4)
        location2.addItem("Shield")
        location2.message = "You are in a clearing. You see a shield on the ground."

        location3.addWest(location1)
        location3.addNorth(location4)
        location3.addEast(location5)
        location3.addItem("Potion")
        location3.message = "You are in a cave. You see a potion on the ground."

        location4.addWest(location2)
        location4.addSouth(location3)
        location4.addEast(location6)
        location4.addItem("Key")
        location4.message = "You are in a field. You see a key on the ground."

        location5.addWest(location3)
        location5.addNorth(location6)
        location5.addEast(location7)
        location5.addItem("Gold")
        location5.message = "You are in a castle. You see a pile of gold on the ground."

        location6.addWest(location4)
        location6.addSouth(location5)
        location6.addEast(location8)
        location6.addItem("Diamond")
        location6.message = "You are in a dungeon. You see a diamond on the ground."

        location7.addWest(location5)
        location7.addNorth(location8)
        location7.addItem("Ruby")
        location7.message = "You are in a tower. You see a ruby on the ground."

        location8.addWest(location6)
        location8.addSouth(location7)
        location8.addEast(location9)
        location8.addItem("Emerald")
        location8.message = "You are in a cave. You see an emerald on the ground."

        location9.addWest(location8)
        location9.addNorth(location10)
        location9.addItem("Silver")
        location9.message = "You are in a cave. You see a silver on the ground."

        location10.addSouth(location9)
        location10.addItem("Bronze")
        location10.message = "You are in a cave. You see a bronze on the ground."

        // Add the locations to the list
        location.add(location1)
        location.add(location2)
        location.add(location3)
        location.add(location4)
        location.add(location5)
        location.add(location6)
        location.add(location7)
        location.add(location8)
        location.add(location9)
        location.add(location10)
    }

    /**
     * Configure the main window
     */
    private fun setupWindow() {
        title = "Kotlin GUI Example"
        contentPane.preferredSize = Dimension(1024, 768)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI
     */
    private fun buildUI() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 20)

        // Label to display the name of the current location
        locationLabel = JLabel("Location", SwingConstants.CENTER)
        locationLabel.bounds = Rectangle(310, 19, 404, 47)
        locationLabel.font = baseFont
        add(locationLabel)

        // Label to display the message for the current location
        messageLabel = JLabel("Message", SwingConstants.CENTER)
        messageLabel.bounds = Rectangle(67, 36, 616, 251)
        messageLabel.font = baseFont
        add(messageLabel)

        // Label to display current inventory
        inventoryLabel = JLabel("Inventory: ", SwingConstants.CENTER)
        inventoryLabel.bounds = Rectangle(733, 36, 223, 251)
        inventoryLabel.font = baseFont
        add(inventoryLabel)

        /**
         * Buttons to move between locations
         */

        // Button to move north
        northButton = JButton("North")
        northButton.bounds = Rectangle(385, 373, 252, 109)
        northButton.font = baseFont
        northButton.addActionListener(this)
        add(northButton)

        // Button to move south
        southButton = JButton("South")
        southButton.bounds = Rectangle(385, 623, 252, 109)
        southButton.font = baseFont
        southButton.addActionListener(this)
        add(southButton)

        // Button to move east
        eastButton = JButton("East")
        eastButton.bounds = Rectangle(658, 499, 252, 109)
        eastButton.font = baseFont
        eastButton.addActionListener(this)
        add(eastButton)

        // Button to move west
        westButton = JButton("West")
        westButton.bounds = Rectangle(114, 499, 252, 109)
        westButton.font = baseFont
        westButton.addActionListener(this)
        add(westButton)
    }

    /**
     * Handle any UI events
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            northButton -> northAction()
            southButton -> southAction()
            eastButton -> eastAction()
            westButton -> westAction()
        }
    }

    private fun westAction() {
        // Move west
        if (currentLocation.west != null) {
            currentLocation = currentLocation.west!!
            showLocation()
        }
    }

    private fun eastAction() {
        // Move east
        if (currentLocation.east != null) {
            currentLocation = currentLocation.east!!
            showLocation()
        }
    }

    private fun southAction() {
        // Move south
        if (currentLocation.south != null) {
            currentLocation = currentLocation.south!!
            showLocation()
        }
    }

    private fun northAction() {
        // Move north
        if (currentLocation.north != null) {
            currentLocation = currentLocation.north!!
            showLocation()
        }
    }

    private fun showLocation() {
        // Display the current location's name
        locationLabel.text = currentLocation.name

        // Display the current location's message
        messageLabel.text = currentLocation.message

        // Display the current location's items
        inventoryLabel.text = "Inventory: ${currentLocation.items.joinToString(", ")}"

        // Enable or disable the north button
        northButton.isEnabled = currentLocation.north != null

        // Enable or disable the south button
        southButton.isEnabled = currentLocation.south != null

        // Enable or disable the east button
        eastButton.isEnabled = currentLocation.east != null

        // Enable or disable the west button
        westButton.isEnabled = currentLocation.west != null
    }
}


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


