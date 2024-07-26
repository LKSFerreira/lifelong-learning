package br.com.alura.orgs.extensions

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import java.security.MessageDigest

fun String.toHash(
    algoritmo: String = "SHA-256"
): String {
    return MessageDigest.getInstance(algoritmo)
        .digest(this.toByteArray())
        .fold("") { str, byte -> str + "%02x".format(byte) }
}