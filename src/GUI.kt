import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import kotlin.system.exitProcess

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
    
    // Create JList to display inventory
    private lateinit var inventoryLabel: JLabel

    // Setup buttons to move between locations
    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton

    // Setup buttons to interact with the location
    private lateinit var takeItemButton: JButton
    private lateinit var useItemButton: JButton

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

        /**
         * Create the locations
         */
        // First location tree
        val darkForest1 = Location("Dark Forest")
        val darkForest2 = Location("Dark Forest")
        val darkForest3 = Location("Dark Forest")
        val gloomyForest = Location("Gloomy Forest")
        val gloomyForest2 = Location("Gloomy Forest")
        val villageOutskirts = Location("Village Outskirts")

        // Second location tree
        val easternOutskirtsPath = Location("Eastern Outskirts Path")
        val easternGuardPost = Location("Eastern Guard Post")

        // Third location tree
        val westernOutskirtsPath = Location("Western Outskirts Path")
        val westernGate = Location("Western Gate")

        // Fourth location tree
        val villageCentre = Location("Village Centre")
        val apothecarysCottage = Location("Apothecary's Cottage")

        /**
         * Create the items
         */
        val rustyShovel = Item("Rusty Shovel", "There is an old shovel leaning against a wall.")
        val key = Item("Key", "You see a patch of recently turned earth.")
        val strengthPotion = Item("Strength Potion", "A small vial of liquid sits on a shelf.")
        val sword = Item("Sword", "Beside you is a gleaming silver sword. Unfortunately, it's seemingly fused into a rock.")

        /**
         * Configure the locations
         */
        darkForest1.addNorth(darkForest2)
        darkForest1.message = "You are in a dark forest. It's cold and damp, but at least your not locked in a cell anymore."

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
        easternOutskirtsPath.addEast(easternGuardPost)
        easternOutskirtsPath.addDiscoverableItem(sword)
        easternOutskirtsPath.addRequiredItem(strengthPotion)
        easternOutskirtsPath.message = "You see a group of armed guards ahead."

        easternGuardPost.addWest(easternOutskirtsPath)
        easternGuardPost.addRequiredItem(sword)
        easternGuardPost.message = "You near the guard post. Five guards are standing watch. If you can get past them you'll finally be free."

        westernOutskirtsPath.addEast(villageOutskirts)
        westernOutskirtsPath.addWest(westernGate)
        westernOutskirtsPath.addDiscoverableItem(key)
        westernOutskirtsPath.addRequiredItem(rustyShovel)
        westernOutskirtsPath.message = "You see a large gate ahead."

        westernGate.addEast(westernOutskirtsPath)
        westernGate.addRequiredItem(key)
        westernGate.message = "You are at the western gate. It is locked."

        villageCentre.addWest(apothecarysCottage)
        villageCentre.addDiscoverableItem(rustyShovel)
        villageCentre.message = "You are in the village centre."

        apothecarysCottage.addEast(villageCentre)
        apothecarysCottage.addDiscoverableItem(strengthPotion)
        apothecarysCottage.message = "You are in the apothecary's cottage."


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
        title = "A Dark Forest"
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
        // Button to take an item
        takeItemButton = JButton("Take Item")
        takeItemButton.bounds = Rectangle(733, 343, 223, 50)
        takeItemButton.font = baseFont
        takeItemButton.addActionListener(this)
        add(takeItemButton)

        // Button to use an item
        useItemButton = JButton("Use Item")
        useItemButton.bounds = Rectangle(733, 400, 223, 50)
        useItemButton.font = baseFont
        useItemButton.addActionListener(this)
        add(useItemButton)
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
            useItemButton -> useItemAction()
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
        // Take the item
        player.addItem(currentLocation.getItem()?.name ?: "")
        currentLocation.removeDiscoverableItem()
        showInventory()
        showLocation()
    }

    private fun useItemAction() {
        // Use the item
        player.removeItem(currentLocation.requiredItem()?.name ?: "")
        // Check for win condition. If the player just used the key or sword then they have won.
        if (currentLocation.requiredItem()?.name == "Key" || currentLocation.requiredItem()?.name == "Sword") {
            JOptionPane.showMessageDialog(this, "Finally, you have escaped the dark forest and are free!")
            exitProcess(0)
        } else {
            currentLocation.removeRequiredItem()
            showInventory()
            showLocation()
        }
    }

    private fun showInventory() {
        // Display the player's inventory
        inventoryLabel.text = "<html>" + "Inventory: <br>" + inventoryList() + "</html>"
    }

    private fun inventoryList(): String {
        // Return a list of items in the player's inventory
        return if (player.getInventory().isEmpty()) {
            "No items in inventory"
        } else {
            player.getInventory().split(", ").joinToString("<br>") { "- $it" }
        }
    }

    /**
     * Update the UI with the current location information
     */
    private fun showLocation() {
        // Display the current location's name
        locationLabel.text = currentLocation.name

        // Display the current location's message
        messageLabel.text = "<html>" + currentLocation.message + " " + currentLocation.itemMessage + "</html>"

        // Enable or disable the north button
        northButton.isEnabled = currentLocation.north != null

        // Enable or disable the south button
        southButton.isEnabled = currentLocation.south != null

        // Enable or disable the east button
        eastButton.isEnabled = currentLocation.east != null

        // Enable or disable the west button
        westButton.isEnabled = currentLocation.west != null

        // Enable or disable the take item button
        if (currentLocation.hasRequiredItem()) {
            takeItemButton.isEnabled = false
        } else {
            takeItemButton.isEnabled = currentLocation.hasItem() && !player.hasItem(currentLocation.getItem()?.name ?: "")
        }
        // Change the text on the take item button to show the item.
        takeItemButton.text = if (currentLocation.hasItem() && !currentLocation.hasRequiredItem()) "Take ${currentLocation.getItem()?.name}" else "Take Item"

        // Enable or disable the use item button
        useItemButton.isEnabled = player.hasItem(currentLocation.requiredItem()?.name ?: "")
        // Change the text on the use item button to show the required item.
        useItemButton.text = if (player.hasItem(currentLocation.requiredItem()?.name ?: "")) "Use ${currentLocation.requiredItem()?.name}" else "Use Item"
    }
}