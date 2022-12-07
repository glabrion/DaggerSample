package com.example.daggersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.add
import com.example.daggersample.screens.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(supportFragmentManager) {
            if (backStackEntryCount == 0) {
                commit {
                    add<MainFragment>(
                        R.id.amFcvFragments
                    )
                }
            }
        }
    }
}