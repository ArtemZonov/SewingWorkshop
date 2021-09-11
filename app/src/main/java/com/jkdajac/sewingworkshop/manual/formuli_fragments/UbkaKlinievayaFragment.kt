package com.jkdajac.sewingworkshop.manual.formuli_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jkdajac.sewingworkshop.R
import kotlinx.android.synthetic.main.fragment_ubka_klinievaya.*
import kotlinx.android.synthetic.main.fragment_ubka_klinievaya.btResult
import kotlinx.android.synthetic.main.fragment_ubka_solnce.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UbkaKlinievayaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbkaKlinievayaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubka_klinievaya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btResult.setOnClickListener {
           T1T2()
        }

        btResult2.setOnClickListener {
            B1B2()
        }
    }

    fun T1T2(){
        val obhvattalii : Int = etOt.text.toString().toInt()
        val pribavka : Int = etPt.text.toString().toInt()
        val n : Int = etN.text.toString().toInt()
        val result = (obhvattalii + pribavka)/0.5*n
        tvResultT1T2.text = result.toString()
    }

    fun B1B2(){
        val obhvattalii : Int = etOt2.text.toString().toInt()
        val pribavka : Int = etPb.text.toString().toInt()
        val n : Int = etN1.text.toString().toInt()
        val result = (obhvattalii + pribavka)/0.5*n
        tvResultB1B2.text = result.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UbkaKlinievayaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UbkaKlinievayaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}