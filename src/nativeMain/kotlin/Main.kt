import org.gtkkn.bindings.gio.ApplicationFlags
import org.gtkkn.bindings.he.Application
import org.gtkkn.bindings.he.ApplicationWindow
import org.gtkkn.bindings.he.FillButton
import org.gtkkn.extensions.gtk.setMargins

private const val APP_ID = "org.gtkkn.samples.gtk.playground"

fun main() {
    // Create a new application
    val app = Application(APP_ID, ApplicationFlags.FLAGS_NONE)

    // Connect to "activate" signal of `app`
    app.connectActivate {
        val button = FillButton("what")
        button.setMargins(12)
        button.connectClicked {
            button.setLabel("WHAT")
        }

        // Create a window and set the title
        val window = ApplicationWindow(app)
        window.setTitle("My GTK App")
        window.setChild(button)

        // Present window
        window.present()
    }

    // Run the application
    app.run(0, emptyList())
}
