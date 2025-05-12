package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                UnitConverter()
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    var inputValue by remember { mutableStateOf("") }
    var isFromMenuExpanded by remember { mutableStateOf(false) }
    var isToMenuExpanded by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Text(
                "Unit Converter",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                label = { Text("Enter the value") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Box(modifier = Modifier.weight(1f)) {
                    Button(
                        onClick = { isFromMenuExpanded = true },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "drop arrow icon",
                        )
                    }

                    DropdownMenu(
                        expanded = isFromMenuExpanded,
                        onDismissRequest = { isFromMenuExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Centimeters") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Meters") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Milimeters") },
                            onClick = {}
                        )
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    Button(
                        onClick = { isToMenuExpanded = true },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "drop arrow icon",
                        )
                    }

                    DropdownMenu(
                        expanded = isToMenuExpanded,
                        onDismissRequest = { isToMenuExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Centimeters") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Meters") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {}
                        )
                        DropdownMenuItem(
                            text = { Text("Milimeters") },
                            onClick = {}
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = "Result: ",
                )
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}