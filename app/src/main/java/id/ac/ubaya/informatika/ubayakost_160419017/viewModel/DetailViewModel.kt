package id.ac.ubaya.informatika.ubayakost_160419017.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.ubayakost_160419017.model.Kost

class DetailViewModel(application: Application): AndroidViewModel(application) {
        val kostLiveData = MutableLiveData<Kost>()
        val Tag = "volleyTag"
        private var queue: RequestQueue? = null

        fun fetch(id: String) {

            queue = Volley.newRequestQueue(getApplication())
            val url = "https://api.npoint.io/e6260fcf7e8aecbe6381/$id"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val sType = object : TypeToken<ArrayList<Kost>>() {}.type
                    val result = Gson().fromJson<ArrayList<Kost>>(it, Kost::class.java)
                    for (i in result) {
                        if (i.id == id)
                            kostLiveData.value = i
                    }

                    Log.d("Show volley: ", result.toString())
                },
                {
                    Log.d("Show volley: ", it.toString())
                }
            ).apply {
                tag = "TAG"
            }
            queue?.add(stringRequest)

        }

}
