package com.erkindilekci.numbermaster.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.numbermaster.R
import com.erkindilekci.numbermaster.ui.theme.NumberMasterTheme
import java.util.concurrent.TimeUnit

@Composable
fun Footer(
    moves: Int,
    secondsElapsed: Long,
    modifier: Modifier = Modifier
) {
    val hours = TimeUnit.SECONDS.toHours(secondsElapsed)
    val minutes =
        TimeUnit.SECONDS.toMinutes(secondsElapsed) - TimeUnit.HOURS.toMinutes(hours)
    val seconds =
        secondsElapsed - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours)

    val timeText = String.format(
        "%02d:%02d:%02d",
        hours, minutes, seconds
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .alpha(0.65f)
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.moves, moves),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            maxLines = 1,
            softWrap = false,
            color = if (isSystemInDarkTheme()) Color(0xFFEFEFEF) else Color.DarkGray
        )
        Text(
            text = timeText,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            maxLines = 1,
            softWrap = false,
            color = if (isSystemInDarkTheme()) Color(0xFFEFEFEF) else Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    NumberMasterTheme {
        Surface {
            Footer(
                moves = 300,
                secondsElapsed = 5_600_000,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FooterPreviewNight() {
    NumberMasterTheme {
        Surface {
            Footer(
                moves = 300,
                secondsElapsed = 5_600_000,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
