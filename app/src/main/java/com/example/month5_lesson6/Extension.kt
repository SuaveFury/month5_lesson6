package com.example.month5_lesson6

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StyleRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

fun Long.formatFunct(): String {
    val date = Date(this)
    val dateFormatType = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return dateFormatType.format(date)
}
fun MaterialAlertDialogBuilder.yesBtn(
    text: String = "YES",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setPositiveButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}
fun MaterialAlertDialogBuilder.noBtn(
    text: String = "NO",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setNegativeButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}
fun MaterialAlertDialogBuilder.okBtn(
    text: String = "OK",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setNeutralButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}

fun Context.bulder(
    @StyleRes style: Int = 0,
    dialogBuilder: MaterialAlertDialogBuilder.() -> Unit
) {
    MaterialAlertDialogBuilder(this, style)
        .apply {
            setCancelable(false)
            dialogBuilder()
            create()
            show()
        }
}



