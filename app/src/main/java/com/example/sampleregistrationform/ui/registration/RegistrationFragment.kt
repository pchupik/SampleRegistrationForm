package com.example.sampleregistrationform.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sampleregistrationform.R
import com.example.sampleregistrationform.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!! // is valid between onCreateView and onDestroyView.

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, this::updateViews)

        binding.run {
            signUpButton.setOnClickListener {
                viewModel.register(nameView.text.toString(), emailView.text.toString())
            }
        }
    }

    private fun updateViews(state: ViewState) {
        binding.run {
            when (state) {
                ViewState.Success -> navigateToHome()
                is ViewState.Error -> {
                    progress.isVisible = false
                    errorView.text = state.msg
                    signUpButton.isEnabled = true
                    nameView.isEnabled = true
                    emailView.isEnabled = true
                }
                ViewState.Loading -> {
                    progress.isVisible = true
                    errorView.text = ""
                    signUpButton.isEnabled = false
                    nameView.isEnabled = false
                    emailView.isEnabled = false
                }
                ViewState.Waiting -> {
                    progress.isVisible = false
                    errorView.text = ""
                    signUpButton.isEnabled = true
                    nameView.isEnabled = true
                    emailView.isEnabled = true
                }
            }
        }

    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}