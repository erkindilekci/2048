package com.erkindilekci.numbermaster.ui.play

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.numbermaster.domain.Game
import com.erkindilekci.numbermaster.ui.components.Footer
import com.erkindilekci.numbermaster.ui.components.GameBoard
import com.erkindilekci.numbermaster.ui.components.Header
import com.erkindilekci.numbermaster.ui.theme.NumberMasterTheme

@Composable
fun PlayScreen(
    score: Int,
    bestScore: Int,
    moves: Int,
    game: Game,
    grid: List<IntArray>,
    timeElapsed: Long,
    modifier: Modifier = Modifier,
    onNewRequest: () -> Unit = {},
    onUndoRequest: () -> Unit = {},
) {
    Scaffold(
        backgroundColor = if (isSystemInDarkTheme()) Color(0xFF9e8d7a) else Color(0xFFFAF8EF),
        content = {
            Column(
                modifier = modifier
                    .padding(it)
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                    .fillMaxSize()
            ) {
                GameBoard(
                    grid = grid,
                    onSwipe = game::swipe,
                )
            }
        },
        topBar = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Header(
                    score = score,
                    bestScore = bestScore,
                    onNewRequest = onNewRequest,
                    onUndoRequest = onUndoRequest
                )
            }
        },
        bottomBar = {
            Column {
                Footer(
                    moves = moves,
                    secondsElapsed = timeElapsed,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PlayScreenPreview() {
    val game = Game(4)
    NumberMasterTheme {
        PlayScreen(
            score = 2048,
            bestScore = 2048,
            moves = 218,
            timeElapsed = 36000L,
            game = game,
            grid = game.grid
        )
    }
}
