package com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.framgianguyenthanhtungh.collapsingtoolbar.BR
import com.example.framgianguyenthanhtungh.collapsingtoolbar.R
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.BaseActivity
import com.example.framgianguyenthanhtungh.collapsingtoolbar.databinding.ActivityMainBinding
import com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather.WeatherFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private var collapsedMenu: Menu? = null
    private var isAppBarExtend: Boolean = true

    companion object {
        private const val TAB_NUMBER = 3
    }

    override val viewModel by viewModel<MainViewModel>()

    override var bindingVariable: Int = BR.mainViewModel

    override fun layoutId(): Int = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?, viewDataBinding: ActivityMainBinding) {
        initToolbar()
        initViews()
    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    private fun initViews() {
        //Appbar Layout
        val appBarLayout = findViewById<AppBarLayout>(R.id.app_bar_layout)
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (Math.abs(verticalOffset) > 200) {
                    isAppBarExtend = false
                    invalidateOptionsMenu()
                } else {
                    isAppBarExtend = true
                    invalidateOptionsMenu()
                }
            }
        })

        //Fab Button
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            doFabAdd()
        }

        //Back Button
        back.setOnClickListener {
            doBack()
        }

        //ViewPager && Fragment Pager Adapter
        val viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        if (collapsedMenu != null && (!isAppBarExtend || collapsedMenu!!.size() != 1)) {
            collapsedMenu!!.add(resources.getString(R.string.menu_add))
                .setIcon(R.drawable.ic_action_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            back.visibility = View.VISIBLE
        } else {
            back.visibility = View.GONE
        }
        return super.onPrepareOptionsMenu(collapsedMenu);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        collapsedMenu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.action_settings -> doSetting()
        }
        if (item.title == resources.getString(R.string.menu_add)) {
            doAdd()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun doFabAdd() {
        Toast.makeText(this, "Clicked fab add", Toast.LENGTH_SHORT).show()
    }

    private fun doBack() {
        Toast.makeText(this, "Clicked back", Toast.LENGTH_SHORT).show()
    }

    private fun doAdd() {
        Toast.makeText(this, "Clicked add", Toast.LENGTH_SHORT).show()
    }

    private fun doSetting() {
        Toast.makeText(this, "Clicked setting", Toast.LENGTH_SHORT).show()
    }

    inner class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return WeatherFragment()
        }

        override fun getCount(): Int {
            return TAB_NUMBER
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "${resources.getString(R.string.tab)} $position"
        }
    }
}
