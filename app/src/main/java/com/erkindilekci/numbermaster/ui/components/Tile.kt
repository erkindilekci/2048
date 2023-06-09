package com.erkindilekci.numbermaster.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.numbermaster.ui.theme.NumberMasterTheme
import com.erkindilekci.numbermaster.ui.theme.Padding

@Composable
fun GameTile(number: Int, size: Dp, dx: Int = 0, dy: Int = 0) {

    val x by animateDpAsState(targetValue = Dp(dx * size.value))
    val y by animateDpAsState(targetValue = Dp(dy * size.value))

    TileBox(
        tile = number,
        modifier = Modifier
            .size(size)
            .padding(Padding.small)
            .absoluteOffset(x, y),
        backgroundColor = getTileColor(num = number)
    ) {
        var textSize by remember { mutableStateOf(32.sp) }

        if (number != 0) Text(
            text = "$number",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = if (number == 1024 && number == 2048) 24.sp else textSize,
            maxLines = 1,
            softWrap = false,
            onTextLayout = { textLayoutResult ->
                if (textLayoutResult.hasVisualOverflow) {
                    textSize *= 0.9
                }
            },
            color = getTileTextColor(num = number)
        )
    }
}

@Composable
private fun getTileColor(
    num: Int
): Color {
    return when (num) {
        2 -> Color(238, 228, 218)
        4 -> Color(237, 224, 200)
        8 -> Color(242, 177, 121)
        16 -> Color(245, 149, 99)
        32 -> Color(246, 124, 95)
        64 -> Color(246, 94, 59)
        128 -> Color(237, 207, 114)
        256 -> Color(237, 204, 97)
        512 -> Color(237, 200, 80)
        1024 -> Color(237, 197, 63)
        2048 -> Color(237, 194, 63)
        else -> if (isSystemInDarkTheme()) Color(0xFFd0ccc8) else Color(0xFFE9E7E5)
    }
}

@Composable
private fun getTileTextColor(
    num: Int
): Color {
    return when (num) {
        2 -> Color.DarkGray
        4 -> Color.DarkGray
        8 -> Color(0xFFFEFEFE)
        16 -> Color(0xFFFEFEFE)
        32 -> Color(0xFFFEFEFE)
        64 -> Color(0xFFFEFEFE)
        128 -> Color(0xFFFEFEFE)
        256 -> Color(0xFFFEFEFE)
        512 -> Color(0xFFFEFEFE)
        1024 -> Color(0xFFFEFEFE)
        2048 -> Color(0xFFFEFEFE)
        else -> if (isSystemInDarkTheme()) Color(0xFFe9e2d9) else Color(0xFF33302a)
    }
}

@Preview(showBackground = true)
@Composable
fun TilePreview() {
    NumberMasterTheme {
        GameTile(32, 92.dp)
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TilePreviewDark() {
    NumberMasterTheme {
        GameTile(32, 92.dp)
    }
}
