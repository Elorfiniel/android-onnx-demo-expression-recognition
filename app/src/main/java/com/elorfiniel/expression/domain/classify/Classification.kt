package com.elorfiniel.expression.domain.classify

import android.graphics.Bitmap

interface Classification {
    fun classify(image: Bitmap): List<ClassificationResult>
}