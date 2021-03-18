package org.abimon.eternalJukebox.objects

import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.abimon.eternalJukebox.data.storage.GoogleStorage
import org.abimon.eternalJukebox.data.storage.IStorage
import org.abimon.eternalJukebox.data.storage.LocalStorage
import kotlin.reflect.KClass

enum class EnumStorageSystem(private val klass: KClass<out IStorage>) {
    LOCAL(LocalStorage::class),
    @ObsoleteCoroutinesApi
    GOOGLE(GoogleStorage::class);

    val storage: IStorage
        get() = klass.objectInstance!!
}