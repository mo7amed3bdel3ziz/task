package com.example.androidtask.UI.viewmodels

import androidx.lifecycle.ViewModel
import com.example.androidtask.business.models.RequestModel
import com.example.androidtask.network.ApiService
import com.example.androidtask.network.wrapWithFlowApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val api: ApiService

) : ViewModel() {

    fun loginVM( requestModel: RequestModel) = wrapWithFlowApi {
        api.LoginApI(requestModel)
    }.flowOn(Dispatchers.IO)
}