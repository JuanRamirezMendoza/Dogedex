package com.jsrm.dogedex.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrm.dogedex.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    interface LoginFragmentActions{

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}