package com.example.androidtask.UI.viewmodels

import androidx.lifecycle.ViewModel
import com.example.androidtask.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUPViewModel  @Inject constructor(
    private val api: ApiService

) : ViewModel() {

}