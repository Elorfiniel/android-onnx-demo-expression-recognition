package com.elorfiniel.expression.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.elorfiniel.expression.presentation.main.CameraRationaleSection
import com.elorfiniel.expression.presentation.main.CameraRequestSection
import com.elorfiniel.expression.ui.camera.CameraScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen() {
    val permissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    when {
        permissionState.status.isGranted -> {
            CameraScreen()
        }

        permissionState.status.shouldShowRationale -> {
            CameraRationaleSection(
                onRequest = { permissionState.launchPermissionRequest() }
            )
        }

        else -> {
            CameraRequestSection(
                onRequest = { permissionState.launchPermissionRequest() }
            )
        }
    }

    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }
}