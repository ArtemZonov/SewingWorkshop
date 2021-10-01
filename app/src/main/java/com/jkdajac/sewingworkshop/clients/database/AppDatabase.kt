package com.jkdajac.sewingworkshop.clients.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = arrayOf(Field::class), version = 2)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun fieldDao(): FieldDao


        companion object {
            @Volatile
            private var INSTANCE: AppDatabase? = null

            val MIGRATION_1_2 = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("DROP TABLE IF EXISTS `profile`")
                    database.execSQL("CREATE TABLE IF NOT EXISTS `profile`(etDis)")
                }
            }

            fun getDatabase(context: Context): AppDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "field_database"
                    )
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }


