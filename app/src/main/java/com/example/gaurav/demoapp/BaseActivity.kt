package com.example.gaurav.demoapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.gaurav.demoapp.news.NewsFragment

/**
 * Created by Gaurav on 04/11/17.
 */

open class BaseActivity : AppCompatActivity() {

    fun changeFragment(f: Fragment,fragmentId: Int, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction();
        if (cleanStack) {
            clearBackStack();
        }
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit);
        ft.replace(fragmentId, f);
        ft.addToBackStack(null);
        ft.commit();
    }

    fun clearBackStack() {
        val manager = supportFragmentManager;
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    /**
     * Finish activity when reaching the last fragment.
     */
    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager;
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack();
        } else {
            finish();
        }
    }
}