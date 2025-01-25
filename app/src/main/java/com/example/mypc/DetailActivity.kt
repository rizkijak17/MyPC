package com.example.mypc

import android.media.MediaPlayer
import android.os.Bundle
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
        val btnAddToCart: Button = findViewById(R.id.btn_add_to_cart)
        val btnBuyNow: Button = findViewById(R.id.btn_buy_now)

        // Ambil data dari Intent
        val pcData = intent.getSerializableExtra("PC_DATA") as? PCItem

        // Isi data ke tampilan
        pcData?.let {
            imgPc.setImageResource(it.image)
            tvTitle.text = it.title
            tvPrice.text = it.price
            tvDetails.text = it.details
        }

        // Tombol Tambahkan ke Keranjang
        btnAddToCart.setOnClickListener {
            // Efek animasi saat tombol ditekan
            val scaleAnim = ScaleAnimation(
                1f, 0.9f, 1f, 0.9f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f
            )
            scaleAnim.duration = 100
            scaleAnim.fillAfter = true
            btnAddToCart.startAnimation(scaleAnim)

            // Tambahkan suara klik
            val mediaPlayer = MediaPlayer.create(this, R.raw.click_sound)
            mediaPlayer.start()

            // Tambahkan ke keranjang (implementasi sesuai kebutuhan)
            // Contoh logika: menambahkan item ke keranjang atau memberi feedback lainnya
        }

        // Tombol Beli Sekarang
        btnBuyNow.setOnClickListener {
            // Efek animasi saat tombol ditekan
            val scaleAnim = ScaleAnimation(
                1f, 0.9f, 1f, 0.9f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f
            )
            scaleAnim.duration = 100
            scaleAnim.fillAfter = true
            btnBuyNow.startAnimation(scaleAnim)

            // Tambahkan suara klik
            val mediaPlayer = MediaPlayer.create(this, R.raw.click_sound)
            mediaPlayer.start()

            // Beli sekarang (implementasi sesuai kebutuhan)
        }
    }

    // Menangani tombol kembali di Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Kembali ke Activity sebelumnya
        return super.onSupportNavigateUp()
    }
}
