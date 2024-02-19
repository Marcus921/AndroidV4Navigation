package com.marcusmalmgren.androidv4navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.marcusmalmgren.androidv4navigation.ui.theme.AndroidV4NavigationTheme

@Composable
fun Welcome(
    stuffvm : StuffViewModel,
    goReadMore : (fruit : String) -> Unit,
    goFancy : () -> Unit
) {
    Column {
        Text(text = "Welcome", modifier = Modifier.background(Color.White))

        Text(stuffvm.someText)

        Button(onClick = {
            goReadMore("Banan")
        }) {
            Text(text = "Read more")
        }
        Button(onClick = {
            goFancy()
        }) {
            Text(text = "Fancy")
        }
        Button(onClick = {
            stuffvm.loadSome()
        }) {
            Text(text = "Load")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    AndroidV4NavigationTheme {
        Welcome(StuffViewModel(), goReadMore = {}, goFancy = {})
    }
}