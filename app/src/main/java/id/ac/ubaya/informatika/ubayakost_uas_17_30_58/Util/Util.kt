package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.room.Room
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.AccountDatabase
import java.lang.Exception

fun ImageView.loadImage(url: String?,progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_location_on_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) { }

        })
}

val DB_ACCOUNT = "account"

fun accountDb(context: Context):AccountDatabase {
    val db = Room.databaseBuilder(context, AccountDatabase::class.java, DB_ACCOUNT).build()
    return db
}