package com.projetos.learnify.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projetos.learnify.model.Items
import com.projetos.learnify.repository.Repository

class HomeViewModel : ViewModel() {
    private val repository = Repository()
    private val _popularCourses = MutableLiveData<List<Items>>()
    val popularCourses: LiveData<List<Items>> = _popularCourses

    init {
        repository.getPopularCourses { items ->
            _popularCourses.value = items
        }
    }
}
