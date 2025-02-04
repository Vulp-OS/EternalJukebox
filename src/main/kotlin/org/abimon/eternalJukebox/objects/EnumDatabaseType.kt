package org.abimon.eternalJukebox.objects

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.abimon.eternalJukebox.data.database.H2Database
import org.abimon.eternalJukebox.data.database.IDatabase
import org.abimon.eternalJukebox.data.database.JDBCDatabase
import kotlin.reflect.KClass

enum class EnumDatabaseType(val db: KClass<out IDatabase>) {
    H2(H2Database::class),
    @ExperimentalCoroutinesApi
    JDBC(JDBCDatabase::class)
}