package com.example.fitness.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant


class HamburgerViewModel : ViewModel() {

    fun onLogOutClick() {
        Constant.isShowBottomNav.value = false
    }
}