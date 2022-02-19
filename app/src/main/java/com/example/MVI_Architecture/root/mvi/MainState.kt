package com.example.MVI_Architecture.root.mvi

sealed class MainState{

    object GetBlogEvent:MainState()

    object NoneEvent:MainState()
}
