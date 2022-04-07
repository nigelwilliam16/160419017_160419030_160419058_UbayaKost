package id.ac.ubaya.informatika.ubayakost_160419017.model

import com.google.gson.annotations.SerializedName


data class Kost(
    var id: String?,
    var namaKost: String?,
    var deskripsi: String?,
    var tipeKost: String?,
    var alamat:String?,
    var harga:String?,
    var telepon:String?,
    var message:String?,
    var pemilik:String?,
    var rekening:String?,
    var foto:String?
)