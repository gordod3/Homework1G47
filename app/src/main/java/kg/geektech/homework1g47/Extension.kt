package kg.geektech.homework1g47

import android.content.Context
import android.widget.Toast

class Extension {
    companion object {
        fun Context.toast(text: String) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}