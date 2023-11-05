package com.keyiflerolsun.kekiktaban

import android.util.Log
import com.keyiflerolsun.kekiktaban.databinding.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View

// * Konum için import'lar
import android.location.LocationManager
import android.location.LocationListener
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat


class KonumFragment : Fragment() {
    private var logTag = "d_KekikTaban"
    private lateinit var binding: KonumFragmentBinding

    public lateinit var locationManager: LocationManager
    public lateinit var locationListener: LocationListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = KonumFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        LocationListener { konum ->
            binding.konumText.text = "konum » ${konum.latitude.toString()},${konum.longitude.toString()}"
            Log.d(logTag, binding.konumText.text.toString())
        }.also { locationListener = it }

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // ? Konum izni verilmemişse izin iste
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            // ? Konum izni verilmişse konum güncellemelerini başlat
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, locationListener)

            val sonBilinenKonum = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            binding.konumText.text = "sonBilinenKonum » ${sonBilinenKonum?.latitude.toString()},${sonBilinenKonum?.longitude.toString()}"
            Log.d(logTag, binding.konumText.text.toString())
        }
    }
}
