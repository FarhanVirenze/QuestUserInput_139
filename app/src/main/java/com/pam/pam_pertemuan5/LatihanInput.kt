package com.pam.pam_pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val datagender = listOf("Laki_laki", "Perempuan")

    var confnama by remember { mutableStateOf("") }
    var confemail by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confgender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Isi nama anda") },
            modifier = modifier.fillMaxWidth().padding(16.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            datagender.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 8.dp)) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender }
                    )
                    Text(text = selectedGender)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Isi email anda") },
            modifier = modifier.fillMaxWidth().padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            placeholder = { Text("Isi alamat anda") },
            modifier = modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = { Text("No Telepon") },
            placeholder = { Text("Isi notelepon anda") },
            modifier = modifier.fillMaxWidth().padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            confnama = nama
            confemail = email
            confalamat = alamat
            confnotelepon = notelepon
            confgender = gender
        }) {
            Text(text = "Simpan")
        }

        TampilData(param = "nama", argu = confnama)
        TampilData(param = "email", argu = confemail)
        TampilData(param = "alamat", argu = confalamat)
        TampilData(param = "notelepon", argu = confnotelepon)
        TampilData(param = "gender", argu = confgender)
    }
}

@Composable
fun TampilData(
    param: String, argu: String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = argu, modifier = Modifier.weight(2f))
        }
    }
}
