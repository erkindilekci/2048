package com.erkindilekci.numbermaster.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.numbermaster.R.string
import com.erkindilekci.numbermaster.ui.theme.NumberMasterTheme

@Composable
fun Header(
    score: Int,
    bestScore: Int,
    modifier: Modifier = Modifier,
    onNewRequest: () -> Unit = {},
    onUndoRequest: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .aspectRatio(1 / 0.75f)
                .weight(1f)
        ) {
            TileBox(
                tile = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFFb4a797) else Color(0xFFdfd9d2)
            ) {
                Text(
                    text = stringResource(string.score),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Black,
                    fontSize = 13.sp,
                    maxLines = 1,
                    softWrap = false,
                )
                Text(
                    text = score.toString(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp,
                    maxLines = 1,
                    softWrap = false,
                )
            }
            TileBox(
                tile = 16,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.7f)
                    .clickable { onNewRequest() },
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFFbfb3a6) else Color(0xFFd5ccc3)
            ) {
                Text(
                    text = stringResource(string.action_new),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    maxLines = 1,
                    softWrap = false,
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .aspectRatio(1 / 0.75f)
                .weight(1f)
        ) {
            TileBox(
                tile = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFFb4a797) else Color(0xFFdfd9d2)
            ) {
                Text(
                    text = stringResource(string.best),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Black,
                    fontSize = 13.sp,
                    maxLines = 1,
                    softWrap = false,
                )
                Text(
                    text = bestScore.toString(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp,
                    maxLines = 1,
                    softWrap = false,
                )
            }
            TileBox(
                tile = 16,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.7f)
                    .clickable { onUndoRequest() },
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFFbfb3a6) else Color(0xFFd5ccc3)
            ) {
                Text(
                    text = stringResource(string.action_undo),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    maxLines = 1,
                    softWrap = false,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeader() {
    NumberMasterTheme {
        Surface {
            Header(
                score = 512,
                bestScore = 1986,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewHeaderNight() {
    NumberMasterTheme {
        Surface {
            Header(
                score = 512,
                bestScore = 1986,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
