package com.example.framgianguyenthanhtungh.collapsingtoolbar.data.pref

import android.content.Context

class PrefHelperImpl(context: Context) : PrefHelper {

    companion object {
        private const val FIRST_RUN = "first_run"
    }

    private val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun isFirstRun(): Boolean = sharedPreferences.getBoolean(FIRST_RUN, true)

    override fun setFirstRun(isFirstRun: Boolean) {
        sharedPreferences.edit().putBoolean(FIRST_RUN, isFirstRun).apply()
    }
}
