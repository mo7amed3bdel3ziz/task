package com.example.androidtask.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidtask.R
import com.example.androidtask.UI.viewmodels.LoginViewModel
import com.example.androidtask.business.models.RequestModel
import com.example.androidtask.databinding.ActivityLoginBinding
import com.example.androidtask.network.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.goSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

            val androidId: String = Settings.Secure.getString(
                contentResolver,
                Settings.Secure.ANDROID_ID
            )
            binding.loginBTn.setOnClickListener {

                if ( CheckAllFields()){
                    lifecycleScope.launch() {
                        viewModel.loginVM(RequestModel(
                            binding.emailID.text.toString(),
                            binding.passwordID.text.toString(),
                            androidId

                        )).collect {

                            when (it) {
                                is State.Loading ->{

                                }
                                is State.Success -> {
                                    Log.d("VisitBranchWithoutPay",it.data.message)
                                }
                                is State.Error -> {
                                    Log.d("VisitBranchWithoutPay",it.messag)
                                }
                            }
                        }
                    }
                }
        }
    }
    }

    private fun CheckAllFields(): Boolean {
        if (binding.emailID.text.isNullOrEmpty()) {
            binding.emailID.setError("This field is required")
            return false
        } else if (binding.passwordID.text.isNullOrEmpty()) {
            binding.passwordID.setError("This field is required")
            return false
        }
        // after all validation return true.
        return true
    }
}