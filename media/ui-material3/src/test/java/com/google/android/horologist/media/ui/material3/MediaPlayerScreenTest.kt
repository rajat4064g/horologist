/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.media.ui.material3

import com.google.android.horologist.media.ui.state.PlayerUiState
import com.google.android.horologist.media.ui.state.model.MediaUiModel
import com.google.android.horologist.media.ui.state.model.TrackPositionUiModel
import com.google.android.horologist.screenshots.rng.WearLegacyScreenTest
import org.junit.Test
import kotlin.time.Duration.Companion.seconds

class MediaPlayerScreenTest() : WearLegacyScreenTest() {

    override fun testName(suffix: String): String {
        return "src/test/snapshots/images/" +
            "${javaClass.`package`?.name}_${javaClass.simpleName}_${testInfo.methodName}_defaultColorScheme.png"
    }

    @Test
    fun mediaPlayerScreen() {
        val playerUiState = PlayerUiState(
            playEnabled = true,
            pauseEnabled = true,
            seekBackEnabled = true,
            seekForwardEnabled = true,
            seekInCurrentMediaItemEnabled = true,
            seekToPreviousEnabled = false,
            seekToNextEnabled = true,
            shuffleEnabled = false,
            shuffleOn = false,
            playPauseEnabled = true,
            playing = true,
            media = MediaUiModel.Ready(
                id = "",
                title = "Weather with You",
                subtitle = "Crowded House",
            ),
            trackPositionUiModel = TrackPositionUiModel.Actual(
                percent = 0.1f,
                position = 30.seconds,
                duration = 300.seconds,
            ),
            connected = true,
        )

        runTest {
            MediaPlayerTestCase(playerUiState = playerUiState)
        }
    }

    @Test
    fun ambientMediaPlayerScreen() {
        val playerUiState = PlayerUiState(
            playEnabled = true,
            pauseEnabled = true,
            seekBackEnabled = true,
            seekForwardEnabled = true,
            seekInCurrentMediaItemEnabled = true,
            seekToPreviousEnabled = false,
            seekToNextEnabled = true,
            shuffleEnabled = false,
            shuffleOn = false,
            playPauseEnabled = true,
            playing = true,
            media = MediaUiModel.Ready(
                id = "",
                title = "Weather with You",
                subtitle = "Crowded House",
            ),
            trackPositionUiModel = TrackPositionUiModel.Actual(
                percent = 0.1f,
                position = 30.seconds,
                duration = 300.seconds,
            ),
            connected = true,
        )

        runTest {
            MediaPlayerTestCase(playerUiState = playerUiState, isAmbientModeEnabled = true)
        }
    }
}
