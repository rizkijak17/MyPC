package com.example.mypc

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Ambil referensi Lottie logo
        val lottieLogo: LottieAnimationView = findViewById(R.id.lottieAnimation)

        // Animasi Lottie dimulai otomatis
        lottieLogo.playAnimation()

        // Durasi splash screen (dalam milidetik)
        val splashScreenDuration = 3000L // 3000 ms = 3 detik

        // Handler untuk berpindah ke MainActivity setelah delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Pindah ke halaman utama (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup SplashActivity agar tidak kembali saat tombol back ditekan
        }, splashScreenDuration)
    }
}
