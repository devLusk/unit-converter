package com.example.unitconverter.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultField(
    inputValue: String,
    inputUnit: String,
    outputUnit: String
) {
    val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0

    val inputToMeters = when (inputUnit) {
        "Centimeters" -> 0.01
        "Millimeters" -> 0.001
        "Feet" -> 0.3048
        "Meters" -> 1.0
        else -> 0.0
    }

    val convertedInput = (inputValueDouble * inputToMeters)

    val result = when (outputUnit) {
        "Centimeters" -> convertedInput * 100
        "Millimeters" -> convertedInput * 1000
        "Feet" -> convertedInput / 0.3048
        "Meters" -> convertedInput * 1
        else -> 0.0
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(15.dp)
    ) {
        Text("Result: $result")
    }
}