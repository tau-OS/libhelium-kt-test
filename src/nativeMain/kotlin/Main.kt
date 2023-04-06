import org.gtk.dsl.gio.onCreateUI
import org.gtk.dsl.gtk.application
import org.gtk.dsl.gtk.applicationWindow
import org.gtk.dsl.gtk.x

fun main() {
    application("org.gtk.example") {
        onCreateUI {
            applicationWindow {
                title = "Window"
                defaultSize = 200 x 200
            }.show()
        }
    }
}