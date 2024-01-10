package com.example.androidtask.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidtask.R
import com.example.androidtask.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)

        binding.goLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.signUpBTN.setOnClickListener {
            if (CheckAllFields()){

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
        else if (binding.confirmedpasswordID.text.isNullOrEmpty()) {
            binding.confirmedpasswordID.setError("This field is required")
            return false
        }
         else if (binding.nameID.text.isNullOrEmpty()) {
            binding.nameID.setError("This field is required")
            return false
        }

        // after all validation return true.
        return true
    }
}