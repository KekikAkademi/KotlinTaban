package com.keyiflerolsun.kekiktaban

import android.util.Log
import com.keyiflerolsun.kekiktaban.databinding.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View

// * HTTP için import'lar
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.lagradost.nicehttp.Requests


class ApiFragment : Fragment() {
    private var logTag = "d_KekikTaban"
    private lateinit var binding: ApiFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ApiFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch {
            apiTest()
        }
    }

    private suspend fun apiTest() : Boolean {
        var oturum = Requests()

        binding.apiText.text = oturum.get("https://wttr.in/Istanbul?format=4").text

        return true
    }
}