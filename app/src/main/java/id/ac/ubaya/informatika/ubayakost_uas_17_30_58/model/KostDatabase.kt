package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Kost::class), version = 1)
abstract class KostDatabase:RoomDatabase() {
    abstract fun kostDao(): KostDAO

    companion object {
        @Volatile
        private var instance: KostDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, KostDatabase::class.java, "kost")
                .build()

        operator fun invoke(context: Context) {
            if (instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}