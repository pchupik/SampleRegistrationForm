package com.example.sampleregistrationform.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.RegisterUserUseCase
import com.example.domain.model.RegistrationResult
import com.example.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val useCase: RegisterUserUseCase) : ViewModel() {

    private val _state = MutableLiveData<ViewState>(ViewState.Waiting)

    val state : LiveData<ViewState> = _state

    fun register(name: String, email: String){
        viewModelScope.launch {
            _state.value = ViewState.Loading
            _state.value = when (val result = useCase.invoke(User(name, email))){
                is RegistrationResult.Error -> ViewState.Error(result.msg)
                RegistrationResult.Success -> ViewState.Success
            }
        }
    }
}