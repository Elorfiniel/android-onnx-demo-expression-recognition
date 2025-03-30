package com.elorfiniel.expression.data.emotion

import android.graphics.Bitmap
import com.elorfiniel.expression.domain.classify.Classification
import com.elorfiniel.expression.domain.classify.ClassificationResult
import javax.inject.Inject

class EmotionClassification @Inject constructor() : Classification {
    override fun classify(image: Bitmap): List<ClassificationResult> {
        val fakeResult = listOf(
            ClassificationResult("Happy", 0.9f),
            ClassificationResult("Sad", 0.1f),
            ClassificationResult("Angry", 0.05f),
            ClassificationResult("Surprise", 0.05f),
            ClassificationResult("Neutral", 0.05f),
        )
        return fakeResult
    }
}