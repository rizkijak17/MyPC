package com.example.mypc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Daftar data PC
        val pcList = listOf(
            PCItem(
                image = R.drawable.pc1,
                title = "PC Gaming Pro",
                description = "PC untuk kebutuhan gaming kelas berat.",
                details = """
                    - Prosesor AMD Ryzen 7 8700F 4.1Ghz Upto 5.0Ghz Cache 16MB 8 Core 16 Thread
                    - Motherboard Asrock B850M AM5
                    - Memory Vgen Platinum DDR5 32GB (16x2) PC44800 5600Mhz
                    - GPU Zotac GeForce RTX 4070 Ti SUPER 16GB White
                    - Monitor KOORUI 24Y1S 23.8 FHD IPS 180Hz
                    - Cooler AIO Liquid Thermaltake TH360
                    - PSU Seasonic VERTEX GX-750
                    - Casing bebas sesuai request
                """.trimIndent(),
                price = "Rp.23.000.000"
            ),
            PCItem(
                image = R.drawable.pc2,
                title = "PC Multimedia",
                description = "PC untuk desain grafis dan multimedia.",
                details = """
                    - Prosesor AMD Ryzen 9 9900X 4.4Ghz Up To 5.6Ghz Cache 64MB 12 Core 24 Thread
                    - Motherboard Gigabyte B850M DS3H AM5
                    - Memory Crucial DDR5 PC44800 64GB (32x2)
                    - GPU Zotac RTX 4090 White 24GB
                    - Monitor BenQ 32 PD3205UA 4K UHD HDR10 100% sRGB
                    - Cooler AIO Liquid Thermaltake TH360
                    - PSU Seasonic VERTEX GX-1000
                    - Casing bebas sesuai request
                """.trimIndent(),
                price = "Rp.45.000.000"
            ),
            PCItem(
                image = R.drawable.pc3,
                title = "PC Kantor",
                description = "PC hemat daya untuk kebutuhan kantor.",
                details = """
                    - Prosesor Intel Core i5-12400 2.5Ghz Up to 4.4Ghz Cache 18MB
                    - Motherboard Asus Prime H610M-R D4 LGA1700
                    - Memory V-Gen TsunamiR DDR4 PC27000 3333Mhz 16GB (2x8)
                    - Monitor SPC 19" SM-19HD
                    - PSU FSP HV PRO 550W 80+
                    - Casing Standard
                """.trimIndent(),
                price = "Rp.7.000.000"
            )
        )

        // RecyclerView setup
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PCAdapter(this, pcList)
    }
}
