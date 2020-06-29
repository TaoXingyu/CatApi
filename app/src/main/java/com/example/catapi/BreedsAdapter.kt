package com.example.catapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catapi.data.Breeds

class BreedsAdapter(var breeds:List<Breeds>): RecyclerView.Adapter<BreedsAdapter.ViewHolder>()  {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        ////navigated to show the following information
        val breedName: TextView = itemView.findViewById(R.id.textview_breedName)
        val breedOrigin: TextView = itemView.findViewById(R.id.textview_breedOrigin)
        val breedDescription: TextView = itemView.findViewById(R.id.textview_breedDescription)
        val breedTemperament: TextView = itemView.findViewById(R.id.textview_breedTemperament)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_breeds, parent, false)
        return ViewHolder(view)    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun onBindViewHolder(holder: BreedsAdapter.ViewHolder, position: Int) {
        val breed = breeds[position]
        holder.breedName.text = breed.name
        holder.breedOrigin.text = breed.origin
        holder.breedDescription.text = breed.description
        holder.breedTemperament.text = breed.temperament
    }
}