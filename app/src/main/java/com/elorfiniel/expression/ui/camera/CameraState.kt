package com.elorfiniel.expression.ui.camera

import com.elorfiniel.expression.domain.classify.ClassificationResult

data class CameraState(
    val results: List<ClassificationResult> = emptyList()
)