package br.com.alura.orgs.extensions

import android.os.Build.VERSION.SDK_INT
import android.widget.ImageView
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.imageLoader
import coil.load
import coil.size.Scale
import lks.ferreira.orgs.R

fun ImageView.tentaCarregarImagem(url: String? = null) {
    val imageLoader = context.imageLoader.newBuilder()
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    load(url, imageLoader) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.loading_icon)
        scale(Scale.FIT)
    }
}