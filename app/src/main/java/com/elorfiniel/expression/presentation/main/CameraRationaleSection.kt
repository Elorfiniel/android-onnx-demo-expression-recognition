package com.elorfiniel.expression.presentation.main

import android.os.Process
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.elorfiniel.expression.R

@Composable
fun CameraRationaleSection(onRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = stringResource(R.string.camera_rationale_section_title))
        },
        text = {
            Text(stringResource(R.string.camera_rationale_section_explain))
        },
        confirmButton = {
            TextButton(onClick = onRequest) {
                Text(stringResource(R.string.camera_rationale_section_confirm))
            }
        },
        dismissButton = {
            TextButton(onClick = { Process.killProcess(Process.myPid()) }) {
                Text(stringResource(R.string.camera_rationale_section_dismiss))
            }
        }
    )
}