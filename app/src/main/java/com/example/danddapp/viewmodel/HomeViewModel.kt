package com.example.danddapp.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.danddapp.extensions.launchSafe
import com.example.danddapp.models.index.Index
import com.example.danddapp.remote.util.Status
import com.example.danddapp.repository.DnD5ThRepository
import com.example.danddapp.repository.Repository
import timber.log.Timber

private const val GET_CLASSES_ERROR = 31
private const val GET_DND_CLASS_ERROR = 323

class HomeViewModel @ViewModelInject constructor(
    private val repository: Repository,
    @Assisted private  val savedStateHandle: SavedStateHandle
): ViewModel(), LifecycleObserver {

    private val _error =  MutableLiveData<Int>()
    val error: LiveData<Int> get() = _error

    private val _classes =  MutableLiveData<Index>()
    val classes: LiveData<Index> get() = _classes

    fun getClasses() {
        viewModelScope.launchSafe{
            repository.getClasses { result ->
                when(result.status) {
                    Status.SUCCESS -> Timber.d("ninja: ${result.data}")
                    Status.ERROR -> _error.postValue(GET_CLASSES_ERROR)
                }
            }
        }
    }

    fun getDnDClass(classIndex: String){
        viewModelScope.launchSafe {
            repository.getDnDClass(classIndex){ result ->
                when(result.status) {
                    Status.SUCCESS -> Timber.d("ninja: ${result.data}")
                    Status.ERROR -> _error.postValue(GET_DND_CLASS_ERROR)
                }
            }
        }
    }

}