package com.elorfiniel.expression.ui.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.util.concurrent.Executors

@Composable
fun CameraScreen(
    viewModel: CameraModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraController = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
            cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
            imageAnalysisBackpressureStrategy =
                ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
            setImageAnalysisAnalyzer(
                Executors.newSingleThreadExecutor()
            ) { imageProxy ->
                val bitmap = imageProxy.toBitmap()
                viewModel.classify(bitmap)
                imageProxy.close()
            }
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = {
            PreviewView(it).apply {
                this.controller = cameraController
                cameraController.bindToLifecycle(lifecycleOwner)
            }
        }
    )
}