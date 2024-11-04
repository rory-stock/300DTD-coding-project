import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

/**
 * GUI class
 * Defines the UI and responds to events
 */
class GUI : JFrame(), ActionListener {

    // Data store
    private val location = mutableListOf<Location>()
    private var currentLocation: Location
    private val player: Player

    // Setup labels to display the current location and location information
    private lateinit var locationLabel: JLabel
    private lateinit var messageLabel: JLabel
    private lateinit var inventoryLabel: JLabel

    // Setup buttons to move between locations
    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton

    // Setup buttons to interact with the location
    private lateinit var takeItemButton: JButton
    private lateinit var useToolButton: JButton

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

        // Create the player
        player = Player()

        // Set the starting location
        currentLocation = location[0]
        showLocation()
        showInventory()
    }

    private fun setupLocations() {

        // Create the locations
        val darkForest1 = Location("Dark Forest")
        val darkForest2 = Location("Dark Forest")
        val darkForest3 = Location("Dark Forest")
        val gloomyForest = Location("Gloomy Forest")
        val gloomyForest2 = Location("Gloomy Forest")
        val villageOutskirts = Location("Village Outskirts")
        val easternOutskirtsPath = Location("Eastern Outskirts Path")
        val westernOutskirtsPath = Location("Western Outskirts Path")
        val villageCentre = Location("Village Centre")

        /**
         * Configure the locations
         */
        darkForest1.addNorth(darkForest2)
        darkForest1.message = "You are in a dark forest."

        darkForest2.addNorth(darkForest3)
        darkForest2.message = "You are in a dark forest."

        darkForest3.addNorth(gloomyForest)
        darkForest3.message = "You are in a dark forest."

        gloomyForest.addNorth(gloomyForest2)
        gloomyForest.message = "You are in a gloomy forest. There is a dim light in the distance."

        gloomyForest2.addNorth(villageOutskirts)
        gloomyForest2.message = "The light ahead is getting brighter."

        villageOutskirts.addNorth(villageCentre)
        villageOutskirts.addEast(easternOutskirtsPath)
        villageOutskirts.addWest(westernOutskirtsPath)
        villageOutskirts.message = "You are at the outskirts of a village."

        easternOutskirtsPath.addWest(villageOutskirts)
        easternOutskirtsPath.message = "You see a group of armed guards ahead."

        westernOutskirtsPath.addEast(villageOutskirts)
        westernOutskirtsPath.message = "You see a locked gate ahead."

        villageCentre.message = "You are in the village centre."
        villageCentre.addTool("Rusty Shovel")

        // Add the locations to the list
        location.add(darkForest1)
        location.add(darkForest2)
        location.add(darkForest3)
        location.add(gloomyForest)
        location.add(gloomyForest2)
        location.add(villageOutskirts)
        location.add(easternOutskirtsPath)
        location.add(westernOutskirtsPath)
        location.add(villageCentre)
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

        /**
         * Buttons to interact with the location
         */
        // Button to take a hidden item
        takeItemButton = JButton("Take Item")
        takeItemButton.bounds = Rectangle(67, 375, 78, 78)
        takeItemButton.font = baseFont
        takeItemButton.addActionListener(this)
        add(takeItemButton)

        // Button to use tool
        useToolButton = JButton("Use Item")
        useToolButton.bounds = Rectangle(878, 375, 78, 78)
        useToolButton.font = baseFont
        useToolButton.addActionListener(this)
        add(useToolButton)
    }

    /**
     * Handle any UI events
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            // Move buttons
            northButton -> northAction()
            southButton -> southAction()
            eastButton -> eastAction()
            westButton -> westAction()

            // Action buttons
            takeItemButton -> takeItemAction()
            useToolButton -> useToolAction()
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

    private fun takeItemAction() {
        // Add the item to the player's inventory
        player.addTool(currentLocation.getDiscoverableItem())
        currentLocation.removeTool()
        showInventory()
    }

    private fun useToolAction() {
        // Use the tool to discover the item
        if (currentLocation.hasTool() && currentLocation.hasItem() && player.hasTool(currentLocation.getUsableTool())) {
            player.addTool(currentLocation.getDiscoverableItem())
            currentLocation.removeTool()
            currentLocation.removeDiscoverableItem()
            showInventory()
        } else {
            messageLabel.text = "You need a tool to use here."
        }
    }

    private fun showInventory() {
        inventoryLabel.text = "Inventory: " + player.getInventory()
    }

    private fun showLocation() {
        // Display the current location's name
        locationLabel.text = currentLocation.name

        // Display the current location's message
        messageLabel.text = currentLocation.message

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