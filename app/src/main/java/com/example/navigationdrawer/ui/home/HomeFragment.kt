package com.example.navigationdrawer.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.ApiInterface
import com.example.navigationdrawer.MyAdapter
import com.example.navigationdrawer.Myapi
import com.example.navigationdrawer.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        recyclerView = binding.recyclerView
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")

            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<Myapi?> {
            override fun onResponse(call: Call<Myapi?>, response: Response<Myapi?>) {
                var responseBody = response.body()
                val productList = responseBody?.comments!!
                myAdapter = MyAdapter(this@HomeFragment, productList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
            }

            override fun onFailure(call: Call<Myapi?>, t: Throwable) {
                Log.d("Home Fragment", "onFailure: " + t.message)
            }
        })


//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}