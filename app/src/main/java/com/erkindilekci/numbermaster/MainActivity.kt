package com.erkindilekci.numbermaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.erkindilekci.numbermaster.repository.PreferenceRepository
import com.erkindilekci.numbermaster.ui.GameScreen

class MainActivity : ComponentActivity() {
    private val preferenceRepository: PreferenceRepository by lazy { PreferenceRepository(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        preferenceRepository.useSystemUiMode = true
        setContent {
            GameScreen()
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceRepository.paused = true
    }
}
