package com.ondev.testwhatsapsendmessage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ondev.testwhatsapsendmessage.ui.theme.TestWhatsapSendMessageTheme
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import java.lang.Exception
import java.lang.StringBuilder


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestWhatsapSendMessageTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CenterPage()
                }
            }
        }
    }
}

@Composable
fun CenterPage() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            try {
                val message = "Enviado desde las apps de Inmersoft... We are great."
                val intent = Intent("android.intent.action.VIEW")
                val stringBuilder = StringBuilder()
                stringBuilder.append("whatsapp://send?phone=+5352557035&text=")
                stringBuilder.append(message)
                intent.data = Uri.parse(stringBuilder.toString())
                context.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }) {
            Text(text = "Send by Whatsapp")
        }
    }
}