package com.elorfiniel.expression.ui.camera

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.elorfiniel.expression.domain.classify.Classification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CameraModel @Inject constructor(
    private val classification: Classification
) : ViewModel() {
    private val _state = MutableStateFlow(CameraState())
    val state = _state.asStateFlow()

    fun classify(image: Bitmap) {
        val results = classification.classify(image)
        _state.update {
            it.copy(results = results)
        }
    }
}