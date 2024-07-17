import android.content.ClipData
import android.content.ClipboardManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.getSystemService


actual class KlipBoard(
    private val onCopy: (String) -> Unit,
    private val onGetLastCopied: () -> String
) {
    actual fun copyToClipboard(
        value: String,
    ) = onCopy(value)

    actual fun getLastCopied(): String = onGetLastCopied.invoke()
}

@Composable
actual fun rememberKlipBoard(): KlipBoard {

    val context = LocalContext.current
    val clipboard = remember {
        context.getSystemService<ClipboardManager>()!!
    }
    return remember {
        KlipBoard(
            onGetLastCopied = {
                val clip = clipboard.primaryClip
                val value = if (clip != null && clip.itemCount > 0) {
                    val text = clip.getItemAt(0).text.toString()
                    text
                } else {
                    ""
                }
                value
            },
            onCopy = {
                val clip = ClipData.newPlainText("copied", it)
                clipboard.setPrimaryClip(clip)
            },
        )
    }

}