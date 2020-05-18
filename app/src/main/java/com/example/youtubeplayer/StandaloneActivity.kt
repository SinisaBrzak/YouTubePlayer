package com.example.youtubeplayer

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {
    private val decoder = Decoder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        buttonPlayVideo.setOnClickListener(this)
        buttonPlayPlaylist.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View) {
        val intent = when (v.id) {
            R.id.buttonPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
                this,
                decoder.decodeKey(getString(R.string.GOOGLE_API_KEY)),
                YOUTUBE_VIDEO_ID,
                0,
                true,
                false
            )
            R.id.buttonPlayPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(
                this,
                decoder.decodeKey(getString(R.string.GOOGLE_API_KEY)),
                YOUTUBE_PLAYLIST,
                0,
                0,
                true,
                false
            )
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}