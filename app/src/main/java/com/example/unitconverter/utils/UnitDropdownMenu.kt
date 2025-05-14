package com.example.unitconverter.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UnitDropdownMenu(
    expanded: Boolean,
    onExpand: () -> Unit,
    onDismiss: () -> Unit,
    mainValue: String,
    onUnitSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Button(
            onClick = onExpand,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(mainValue)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "drop arrow icon")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismiss
        ) {
            listOf("Centimeters", "Meters", "Feet", "Milimeters").forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onUnitSelected(it)
                        onDismiss()
                    }
                )
            }
        }
    }
}
