package com.saadahmedsoft.e_commerce_assignment.view.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.helper.delay
import com.saadahmedsoft.e_commerce_assignment.view.accountType.AccountTypeActivity
import com.saadahmedsoft.shortintent.Anim
import com.saadahmedsoft.shortintent.ShortIntent

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delay(750) {
            ShortIntent.getInstance(this)
                .addDestination(AccountTypeActivity::class.java)
                .addTransition(Anim.FADE)
                .finish(this)
        }
    }
}