package com.example.mypc

import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Set Toolbar sebagai ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white, theme))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val backIcon = resources.getDrawable(R.drawable.ic_arrow_back, theme)
        backIcon.setTint(resources.getColor(android.R.color.white, theme))
        supportActionBar?.setHomeAsUpIndicator(backIcon)

        // Bind views
        val imgPc: ImageView = findViewById(R.id.img_pc)
        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvPrice: TextView = findViewById(R.id.tv_price)
        val tvDetails: TextView = findViewById(R.id.tv_details)
        val btn_chat: Button = findViewById(R.id.btn_chat)
        val btnAddToCart: Button = findViewById(R.id.btn_cart)
        val btnBuyNow: Button = findViewById(R.id.btn_checkout)

        // Ambil data dari Intent
        val pcData = intent.getSerializableExtra("PC_DATA") as? PCItem

        // Isi data ke tampilan
        pcData?.let {
            imgPc.setImageResource(it.image)
            tvTitle.text = it.title
            tvPrice.text = it.price
            tvDetails.text = it.details
        }

        // Fungsi untuk menambahkan animasi dan aksi pada tombol
        fun applyButtonAnimation(button: Button) {
            val scaleAnim = ScaleAnimation(
                1f, 0.9f, 1f, 0.9f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f
            )
            scaleAnim.duration = 100
            scaleAnim.fillAfter = false
            scaleAnim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    // Reset ukuran tombol ke semula
                    button.scaleX = 1f
                    button.scaleY = 1f
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })

            // Mulai animasi
            button.startAnimation(scaleAnim)

            // Tambahkan suara klik
            val mediaPlayer = MediaPlayer.create(this@DetailActivity, R.raw.click_sound)
            mediaPlayer.start()
        }

        // Terapkan animasi dan logika pada setiap tombol
        btn_chat.setOnClickListener {
            applyButtonAnimation(btn_chat)
            // Tambahkan logika untuk tombol chat di sini
        }

        btnAddToCart.setOnClickListener {
            applyButtonAnimation(btnAddToCart)
            // Tambahkan logika untuk tombol Tambahkan ke Keranjang di sini
        }

        btnBuyNow.setOnClickListener {
            applyButtonAnimation(btnBuyNow)
            // Tambahkan logika untuk tombol Beli Sekarang di sini
        }
    }

    // Menangani tombol kembali di Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Kembali ke Activity sebelumnya
        return super.onSupportNavigateUp()
    }
}
