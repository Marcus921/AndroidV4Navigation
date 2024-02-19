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
fun ReadMore(stuffVM : StuffViewModel, fruit : String, goFancy : () -> Unit) {
    Column {
        Text(text = "ReadMore $fruit", modifier = Modifier.background(Color.White))

        Text(stuffVM.someText)

        Button(onClick = {
            goFancy()
        }) {
            Text(text = "Fancy")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ReadMorePreview() {
    AndroidV4NavigationTheme {
        ReadMore(StuffViewModel(),"ABC", goFancy = {})
    }
}