package com.example.actividad_27_05_2024

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoViewActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        videoView = findViewById(R.id.vvVideo)
        val mcVideo = MediaController(this)
        mcVideo.setAnchorView(videoView)
        videoView.setMediaController(mcVideo)

        val ruta = Uri.parse("https://developer.android.com/static/studio/videos/studio-install-windows.mp4")
        videoView.setVideoURI(ruta)
        videoView.requestFocus()
        videoView.start()
    }
}
