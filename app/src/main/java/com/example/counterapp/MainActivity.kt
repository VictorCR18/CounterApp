package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

// Classe principal da atividade
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Define o tema da aplicação
            CounterAppTheme {
                // Define a superfície da tela com a cor de fundo padrão do tema
                Surface(
                    modifier = Modifier.fillMaxSize(), color =
                    MaterialTheme.colors.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

// Função composable principal que define a interface do usuário da calculadora
@Composable
fun CounterApp() {
    // Estado para armazenar o resultado das operações
    var result by remember { mutableStateOf(0.0) }
    // Estado para armazenar o valor de entrada do usuário
    var input by remember { mutableStateOf("") }
    // Estrutura em coluna para alinhar elementos verticalmente
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Alinhamento horizontal centralizado
        modifier = Modifier
            .fillMaxSize() // Ocupa todo o espaço disponível
            .padding(16.dp), // Adiciona espaçamento nas bordas
        verticalArrangement = Arrangement.Center // Centraliza os elementos verticalmente
    ) {
        // Exibe o resultado atual
        Text(
            text = "Resultado: $result",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
// Campo de entrada para número, onde o usuário digita um valor
        OutlinedTextField(
            value = input,
            onValueChange = { input = it }, // Atualiza o valor de input com o valor digitado
            label = { Text("Digite um número") },
            modifier = Modifier.fillMaxWidth() // Ocupa a largura total
        )
        Spacer(modifier = Modifier.height(16.dp)) // Espaço entre o campo de entrada e os botões
        // Linha com os botões de incremento e decremento
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaçamento entre os botões
            modifier = Modifier.fillMaxWidth()
        ) {
            // Botão Incrementar
            ElevatedButton(
                onClick = {
                    result += input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text="Adicionar",
                    color = Color.White)
            }// Botão Decrementar
            ElevatedButton(
                onClick = {
                    result -= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text="Subtrair",
                    color = Color.White)

            }}

        // Linha com os botões de multiplicação e divisão
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaçamento entre os botões
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp) // Espaçamento superior
        ) {
            // Botão Multiplicar
            ElevatedButton(
                onClick = {
                    result *= input.toDoubleOrNull() ?: 1.0
                    input = ""
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text="Multiplicar",
                    color = Color.White)

            }// Botão Dividir
            ElevatedButton(
                onClick = {
                    val value = input.toDoubleOrNull() ?: 1.0
                    if (value != 0.0) {
                        result /= value
                    }
                    input = ""
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text="Dividir",
                    color = Color.White)

            }
        }
        Spacer(modifier = Modifier.height(16.dp)) // Espaço antes do botão Limpar
        // Botão Limpar para redefinir o resultado e o campo de entrada
        ElevatedButton(
            onClick = {
                result = 0.0
                input = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text="Subtrair",
                color = Color.White)        }
    }
}
