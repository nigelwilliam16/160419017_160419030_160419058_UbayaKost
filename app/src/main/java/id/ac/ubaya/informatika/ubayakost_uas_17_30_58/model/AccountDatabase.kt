package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Account::class), version = 1)
abstract class AccountDatabase:RoomDatabase() {
    abstract fun accountDao(): AccountDAO

    companion object {
        @Volatile
        private var instance: AccountDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AccountDatabase::class.java, "account")
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