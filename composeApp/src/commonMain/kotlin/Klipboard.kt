import androidx.compose.runtime.Composable


expect class KlipBoard {


    fun copyToClipboard(
        value: String,
    )

    fun getLastCopied(): String
}

@Composable
expect fun rememberKlipBoard(): KlipBoard