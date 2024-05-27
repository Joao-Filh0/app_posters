package com.example.appposters.ui.pages.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.appposters.core.models.PostModel
import com.example.appposters.utils.extensions.textCapitalize

@Composable
fun CardTitleComponent(post: PostModel, onTap: () -> Unit) {

    Card(modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(24.dp).fillMaxWidth().pointerInput(Unit) {
            detectTapGestures(
                onTap = { onTap() }
            )
        }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    // add because api can't return urlImage
                    model = "https://picsum.photos/id/${post.id}/300/500",
                    contentDescription = "Example Image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp).clip(RoundedCornerShape(10.dp))
                        .border(
                            BorderStroke(2.dp, Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = post.title.textCapitalize(),
                    color = Color.Black,
                    style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                )
            }
            Divider(modifier = Modifier.padding(vertical = 20.dp), color = Color.Gray)
            Text(text = post.body)

        }
    }

}
