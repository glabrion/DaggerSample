package com.example.daggersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.add
import com.example.daggersample.screens.main.MainFragment
import com.example.daggersample.screens.main.MainFragment.Companion.PAGE_KEY
import com.example.daggersample.screens.main.MainFragment.Companion.TAG

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(supportFragmentManager) {
            if (backStackEntryCount == 0) {
                commit {
                    add<MainFragment>(
                        containerViewId = R.id.amFcvFragments,
                        tag = TAG,
                        args = Bundle().apply {
                            putInt(PAGE_KEY, 1)
                        }
                    )
                }
            }
        }
    }
}