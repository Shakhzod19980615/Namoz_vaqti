package com.example.namoz_vaqti.ui

import android.Manifest
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.namoz_vaqti.R
import com.example.namoz_vaqti.data.common.MySettings
import com.example.namoz_vaqti.databinding.FragmentSplashBinding
import com.example.namoz_vaqti.di.AppComponent
import java.util.*

import javax.inject.Inject
import kotlin.properties.Delegates


class SplashFragment : Fragment(R.layout.fragment_splash) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //private var viewModel: MainCategoryViewModel by Delegates.notNull()
    private var binding : FragmentSplashBinding by Delegates.notNull()
    private lateinit var latitude: String
    private lateinit var longitude: String
    private  var mySetting : MySettings = MySettings
    private var appContext: Context? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
        //returning view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chooseCity.isEnabled = false
        if(ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION),111)
        else{
            binding.chooseCity.isEnabled = true
            binding.chooseCity.setOnClickListener {
                val cityName = binding.cityName.text.toString()
                val geocoder = Geocoder(requireContext(), Locale.getDefault())
                val addresses = geocoder.getFromLocationName(cityName, 2)
                var address: Address? = addresses?.get(0)
                latitude = address?.latitude.toString()
                longitude = address?.longitude.toString()
                mySetting.setLatitude(latitude)
                mySetting.setLongtitude(longitude)
                binding.latitude.text = latitude
                binding.longitude.text = longitude
                print(latitude)
                print(longitude)
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            binding.chooseCity.isEnabled = true
        }
    }

}