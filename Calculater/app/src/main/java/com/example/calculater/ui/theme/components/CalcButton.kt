package com.example.calculater.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculater.ui.theme.CalculaterTheme

val Black = Color(0xFF000000)
val Gray = Color(0xFFB0B0B0)  // Cor cinza

@Composable
fun CalcButton(
    modifier: Modifier = Modifier,
    label: String = "",
    isOperation: Boolean = false,
    onButtonPress: (String) -> Unit
) {
    Button(
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(if (isOperation) Black else Gray),
        onClick = { onButtonPress(label) }
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isOperation) Color.White else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    CalculaterTheme {
        CalcButton(
            label = "0"
        ) { }
    }
}
