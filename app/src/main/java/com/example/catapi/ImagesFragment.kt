package com.example.catapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ImagesFragment : Fragment() {
    //Execute request and display data
    //create object used lazy, can be reused
    val apiService by lazy {
        ApiService.create()
    }

    //disposable object tracks the fetching activity,以防抓取数据完成前活动被销毁而导致崩溃
    // var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_images, container, false)

    }
}
