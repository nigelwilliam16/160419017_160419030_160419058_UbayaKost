package id.ac.ubaya.informatika.ubayakost_160419017.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.ubayakost_160419017.R
import id.ac.ubaya.informatika.ubayakost_160419017.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_160419017.model.Kost
import kotlinx.android.synthetic.main.detail_kost_card.view.*
import kotlinx.android.synthetic.main.fragment_list_kost.view.*
import java.util.ArrayList

class ListKostAdapter(val listKost: ArrayList<Kost>) : RecyclerView.Adapter<ListKostAdapter.ListKostViewHolder>() {
    class ListKostViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.detail_kost_card, parent, false)
        return ListKostViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListKostViewHolder, position: Int) {
        val kost = listKost[position]
        with(holder.view) {
            textViewNamaKost.text = kost.namaKost
            textViewGender.text = kost.tipeKost
            buttonLocation.text = kost.alamat
            buttonDetail.setOnClickListener {
                val action = FragmentListKostDirections.actionDetailKost(kost.namaKost.toString())

                Navigation.findNavController(it).navigate(action)
            }
            imageViewKost.loadImage(kost.foto, holder.view.progressBarDetail)
        }
    }

    override fun getItemCount() =  listKost.size

    fun updateKostList(newKostList: ArrayList<Kost>) {
        listKost.clear()
        listKost.addAll(newKostList)
        notifyDataSetChanged()
    }

}