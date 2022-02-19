package com.example.MVI_Architecture.root.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MVI_Architecture.root.domain.BlogModel
import com.example.MVI_Architecture.root.mvi.MainState
import com.example.MVI_Architecture.root.repository.MainRepository
import com.example.MVI_Architecture.root.utils.DataState
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@Assisted savedStateHandle: SavedStateHandle,private val mainRepository: MainRepository) :
    ViewModel() {

    val dataStateLiveData = MutableLiveData<DataState<List<BlogModel>>>()


    fun setSateEvent(mainState: MainState){
        viewModelScope.launch {
            when(mainState){
                MainState.GetBlogEvent -> {
                    mainRepository.getBlogs()
                        .onEach { dataState ->
                            dataStateLiveData.postValue(dataState)
                        }.launchIn(viewModelScope)
                }
                MainState.NoneEvent -> {}
            }
        }
    }
}
