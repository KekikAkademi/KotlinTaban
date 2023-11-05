package com.keyiflerolsun.kekiktaban

import android.util.Log
import com.keyiflerolsun.kekiktaban.databinding.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// * Konum için import'lar
import android.location.LocationManager
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager


class AnaActivity : AppCompatActivity() {
    private var logTag = "d_KekikTaban"
    private lateinit var binding: AnaActivityBinding

    private val fragmentManager     = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()
    private val konumFragment       = KonumFragment()
    private val apiFragment         = ApiFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(logTag, "Başladım Kanka")

        fragmentTransaction.add(R.id.konumLayout, konumFragment)
        fragmentTransaction.add(R.id.apiLayout, apiFragment)
        fragmentTransaction.commit()
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        // ! ilk defa konum izni verildiğinde çalışır
        if (requestCode == 1) {
            if (grantResults.isNotEmpty()) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    // ? Konum izni verilmişse konum güncellemelerini başlat
                    konumFragment.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, konumFragment.locationListener)
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}