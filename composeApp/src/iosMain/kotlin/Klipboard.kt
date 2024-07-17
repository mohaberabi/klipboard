import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.UIPasteboard

actual class KlipBoard {
    actual fun copyToClipboard(value: String) {
        UIPasteboard.generalPasteboard.string = value
    }

    actual fun getLastCopied(): String = UIPasteboard.generalPasteboard.string ?: ""
}


@Composable
actual fun rememberKlipBoard(): KlipBoard {
    return remember {
        KlipBoard()
    }
}