package com.elorfiniel.expression.di

import com.elorfiniel.expression.data.emotion.EmotionClassification
import com.elorfiniel.expression.domain.classify.Classification
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindClassification(impl: EmotionClassification) : Classification
}