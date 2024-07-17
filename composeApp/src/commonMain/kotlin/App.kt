import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


const val copied = "I Love Kotlin"

@Composable
fun App() {
    var text by remember {
        mutableStateOf("")
    }


    val klipBoard = rememberKlipBoard()
    MaterialTheme {


        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
            ) {


                Row {

                    Text("Press the button to copy me ")
                    TextButton(
                        onClick = { klipBoard.copyToClipboard(copied) },
                    ) {
                        Text("copy")
                    }
                }



                Text("Press the button to paste")
                Text(text)
                Button(
                    onClick = {
                        text = klipBoard.getLastCopied()
                    },
                ) {
                    Text("Paste")
                }
            }
        }
    }
}