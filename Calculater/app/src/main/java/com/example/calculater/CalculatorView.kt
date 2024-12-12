package com.example.calculater

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculater.ui.theme.CalculaterTheme
import com.example.calculater.ui.theme.components.CalcButton

@Composable
fun CalculatorView(modifier: Modifier = Modifier) {
    var display by remember { mutableStateOf("0") } // Display da calculadora
    var operand by remember { mutableStateOf(0.0) } // Armazena o primeiro valor (operand)
    var currentOperation by remember { mutableStateOf<String?>("") } // Armazena a operação selecionada
    var isOperationPressed by remember { mutableStateOf(false) } // Para controlar se uma operação foi pressionada

    // Função para atualizar o display com os números pressionados
    val onNumPress: (String) -> Unit = { num ->
        if (display == "0" || isOperationPressed) {
            display = num
            isOperationPressed = false
        } else {
            display += num
        }
    }

    // Função para lidar com a operação
    val onOperationPress: (String) -> Unit = { operation ->
        operand = display.toDouble() // Armazena o valor atual
        currentOperation = operation // Armazena a operação selecionada
        isOperationPressed = true // Marca que a operação foi pressionada
    }

    // Função para calcular o resultado
    val onEqualPress: (String) -> Unit = { _ -> // O argumento é necessário para o CalcButton funcionar
        val result = when (currentOperation) {
            "+" -> operand + display.toDouble()
            "-" -> operand - display.toDouble()
            "*" -> operand * display.toDouble()
            "/" -> if (display.toDouble() != 0.0) operand / display.toDouble() else "Erro"
            else -> display.toDouble()
        }
        display = result.toString()
        operand = 0.0 // Reseta o primeiro valor
        currentOperation = "" // Reseta a operação
    }

    // Layout principal
    Box(
        modifier = modifier
            .padding(20.dp)
            .border(2.dp, Color.Black)
            .padding(20.dp)
    ) {
        Column {

            // Display do resultado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .border(2.dp, Color.Black)
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = display,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Caixa com borda ao redor dos botões
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black)
                    .padding(10.dp)
            ) {
                Column {

                    // Primeira linha de botões
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        CalcButton(
                            modifier = Modifier.weight(1.5f),
                            label = "AC",
                            isOperation = true,
                            onButtonPress = { display = "0" }
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "(",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = ")",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "%",
                            isOperation = true,
                            onButtonPress = { onOperationPress("%") }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Segunda linha de botões
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "7",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "8",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "9",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "*",
                            isOperation = true,
                            onButtonPress = { onOperationPress("*") }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Terceira linha de botões
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "4",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "5",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "6",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "-",
                            isOperation = true,
                            onButtonPress = { onOperationPress("-") }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Quarta linha de botões
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "1",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "2",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "3",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "+",
                            isOperation = true,
                            onButtonPress = { onOperationPress("+") }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Quinta linha de botões
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "0",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = ",",
                            onButtonPress = onNumPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "=",
                            isOperation = true,
                            onButtonPress = onEqualPress
                        )
                        CalcButton(
                            modifier = Modifier.weight(1f),
                            label = "/",
                            isOperation = true,
                            onButtonPress = { onOperationPress("/") }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculaterTheme {
        CalculatorView()
    }
}
