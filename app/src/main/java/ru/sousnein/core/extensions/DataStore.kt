package ru.sousnein.core.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import java.io.File

fun DataStore<*>.deleteDataStore(context: Context, fileName: String) {
    val DATASTORE_PATH = "datastore/"
    val PREFERENCE_EXTENSION = ".json"
    val file = File(context.filesDir, "$DATASTORE_PATH$fileName$PREFERENCE_EXTENSION")
    file.delete()
}