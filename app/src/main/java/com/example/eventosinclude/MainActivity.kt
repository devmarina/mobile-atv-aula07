package com.example.eventosinclude
import androidx.compose.material3.ExperimentalMaterial3Api //alt enter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eventosinclude.ui.theme.EventosIncludeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventosIncludeTheme {
                TelaEvento()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class) //estava dando erro no topapbar, entao ao clicar alt enter foi indicado o uso.
@Composable
fun TelaEvento() {
    var email by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Eventos Include")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Capacitação: Desenvolvimento de sistemas com React",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Aprenda a principal stack da Empresa Júnior de tecnologia de Russas.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "13 de outubro • 18h00",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Include Jr, Russas",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Text(
                text = "Validação:",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Insira seu e-mail de Trainee para validarmos sua entrada"
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text("e-mail do trainee")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    mensagem = "Presença confirmada para $email!"
                },
                enabled = email.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("CONFIRMAR PRESENÇA")
            }
            if (mensagem.isNotEmpty()) {
                Text(
                    text = mensagem,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TelaEventoPreview() {
    EventosIncludeTheme {
        TelaEvento()
    }
}