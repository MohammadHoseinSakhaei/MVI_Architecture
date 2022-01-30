package com.example.myapplication.root.mvi

sealed class MainState{

    object GetBlogEvent:MainState()

    object NoneEvent:MainState()
}
