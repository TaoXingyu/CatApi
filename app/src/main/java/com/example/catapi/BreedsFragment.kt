package com.example.catapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catapi.data.Breeds
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_breeds.*

class BreedsFragment : Fragment(){
    //lateinit var breedAdapter: BreedAdapter

    //Execute request and display data
    //create object used lazy, can be reused
    val apiService by lazy {
        ApiService.create()
    }
    //disposable object tracks the fetching activity,以防抓取数据完成前活动被销毁而导致崩溃
    var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_breeds, container, false)
        //fetch data
        disposable =
            apiService.getbreeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showResponse, this::Error)
        return view
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    //show Error
    private fun Error(t: Throwable) {

    }

    //show Result
    private fun showResponse(response: List<Breeds>) {
        breedsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = BreedsAdapter(response)
        }
    }
}