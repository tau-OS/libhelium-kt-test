import org.gtkkn.bindings.gio.ApplicationFlags
import org.gtkkn.bindings.he.Application

@DslMarker
@Target(AnnotationTarget.FUNCTION)
annotation class GtkDsl

@GtkDsl
inline fun Application(id: String, flags: ApplicationFlags, block: Application.() -> Unit): Application {
    return Application(id, flags).apply(block)
}