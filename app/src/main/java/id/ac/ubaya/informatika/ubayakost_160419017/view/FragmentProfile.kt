package id.ac.ubaya.informatika.ubayakost_160419017.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_160419017.R
import id.ac.ubaya.informatika.ubayakost_160419017.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_160419017.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment__profile.*
import kotlinx.android.synthetic.main.fragment_my_kost.*

class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val nama = FragmentProfileArgs.fromBundle(requireArguments()).nama
            val phone = FragmentProfileArgs.fromBundle(requireArguments()).phone
            val email = FragmentProfileArgs.fromBundle(requireArguments()).email

            textViewNama.setText(nama)
            textViewEmail.setText(phone)
            textViewPhoneNumber.setText(email)

        }

        imageViewProfile.loadImage("https://thumb.suara.com/REOX2RJtISUhU58TydB9iw1PEbg=/653x366/https://media.suara.com/pictures/653x366/2022/02/15/99844-ilustrasi-pria-sedang-bekerja-pexelscomandrea-piacquadio.jpg", progressBarProfile)
        buttonEditProfile.setOnClickListener {
            Navigation.findNavController(it).navigate(FragmentProfileDirections.actionItemProfileToFragmentEditProfile(textViewNama.text.toString(),textViewPhoneNumber.text.toString(),textViewEmail.text.toString()))
        }
    }
}