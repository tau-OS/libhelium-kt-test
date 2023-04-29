import org.gtkkn.bindings.gio.*
import org.gtkkn.bindings.gtk.*
import org.gtkkn.bindings.he.*
import org.gtkkn.bindings.he.Application
import org.gtkkn.bindings.he.ApplicationWindow
import org.gtkkn.extensions.gtk.setMargins

private const val APP_ID = "org.gtkkn.samples.gtk.playground"

fun main() {
    // Create a new application
    val app = Application(APP_ID, ApplicationFlags.FLAGS_NONE)

    val mainMenu = Menu().apply {
        insertItem(0, MenuItem("About Abacus", "win.action-about"))
    }

    // Connect to "activate" signal of `app`
    app.connectActivate {
        val box = Box(Orientation.VERTICAL, 5)

        val appBar = AppBar()
        appBar.setShowBack(false)
        appBar.setViewtitleWidget(DropDown(listOf("Temperature", "Mass", "Length")).apply {
            visible = false
            halign = Align.START
            cssClasses = listOf("view-switcher")
        })

        appBar.append(MenuButton().apply {
            menuModel = mainMenu
            setIconName("open-menu")
        })

        box.append(appBar)

        val button = FillButton("what")
        button.setMargins(12)
        button.connectClicked {
            button.setLabel("WHAT")
        }
        box.append(button)

        // Create a window and set the title
        val window = ApplicationWindow(app)
        window.setTitle("My GTK App")
        window.setChild(box)

        val aboutAction = SimpleAction("action-about", null)
        aboutAction.connectActivate {
            val aboutWindow = AboutWindow(
                parent = window,
                appName = "Abacus",
                appId = "com.fyralabs.Abacus",
                version = "0.0.0",
                icon = "com.fyralabs.Abacus",
                translateUrl = "https://fyralabs.com",
                issueUrl = "https://fyralabs.com",
                moreInfoUrl = "https://fyralabs.com",
                translators = listOf(""),
                translatorsLength1 = 0,
                developers = listOf("Fyra Labs"),
                developersLength1 = 1,
                copyrightYear = 2022,
                license = AboutWindowLicenses.GPLV3,
                color = Colors.PURPLE
            )
            aboutWindow.present()
        }
        window.addAction(aboutAction)

        // Present window
        window.present()
    }

    // Run the application
    app.run(0, emptyList())
}
