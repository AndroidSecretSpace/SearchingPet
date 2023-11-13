package com.example.searchingpet.view

import android.content.Context
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.UiThread
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.searchingpet.R
import com.example.searchingpet.databinding.FragmentMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.AndroidEntryPoint
import com.naver.maps.map.MapFragment
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Overlay
import java.util.Locale

@AndroidEntryPoint
class MapFragment : Fragment(), OnMapReadyCallback, Overlay.OnClickListener {
    private lateinit var binding: FragmentMapBinding
    private val marker = Marker()

    private val infoWindow = InfoWindow()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMapView()


    }


    // 네이버맵 객체 초기화
    private fun initMapView() {
        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_fragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_fragment, this).commit()
            }

        mapFragment.getMapAsync(this)


    }


    @UiThread
    override fun onMapReady(naverMap: NaverMap) {

        marker.position = LatLng(37.5670135, 126.9783740)
        marker.map = naverMap
        marker.onClickListener = this




        naverMap.setOnMapClickListener { point, coord ->
            marker(coord.latitude, coord.longitude)
        }

        val listener = Overlay.OnClickListener { overlay ->
            val marker = overlay as Marker

            if (marker.infoWindow == null) {
                // 현재 마커에 정보 창이 열려있지 않을 경우 엶
                infoWindow.open(marker)
            } else {
                // 이미 현재 마커에 정보 창이 열려있을 경우 닫음
                infoWindow.close()
            }

            true
        }



        marker.onClickListener = listener

    }


    private fun marker(latitude: Double, longitude: Double) {
        marker.position = LatLng(latitude, longitude)
        getAddress(latitude, longitude)
    }


    // 좌표 -> 주소 변환
    private fun getAddress(latitude: Double, longitude: Double) {
        val geocoder = Geocoder(requireContext(), Locale.KOREAN)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            geocoder.getFromLocation(
                latitude, longitude, 1
            ) { address ->
                if (address.size != 0) {
                    toast(address[0].getAddressLine(0))
                }
            }
        } else {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses != null) {
                toast(addresses[0].getAddressLine(0))

                infoWindow.adapter = object : InfoWindow.DefaultTextAdapter(requireContext()) {
                    override fun getText(infoWindow: InfoWindow): CharSequence {
                        return addresses[0].getAddressLine(0) as CharSequence
                    }

                }
            }

        }

    }

    private fun toast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()

    }

    private fun markerClickedAddressShow() {


    }

    override fun onClick(overlay: Overlay): Boolean {

        if (overlay is Marker) {
//            Toast.makeText(requireContext(), "마커가 선택되었습니다", Toast.LENGTH_SHORT).show()
            return true
        }

        return false

    }


}