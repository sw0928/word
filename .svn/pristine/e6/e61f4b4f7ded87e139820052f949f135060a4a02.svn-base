package tts.moudle.api.cityapi;

import android.database.sqlite.SQLiteDatabase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sjb on 2016/3/15.
 */
public class CityDbHelper {

    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Lock readLock  = lock.readLock();
    private Lock writeLock   = lock.writeLock();

    public SQLiteDatabase getReadableDataBase(String databaseDirPath,String databaseFileName) {

        readLock.lock();

        try {
            String databasePath = databaseDirPath.concat(databaseFileName);

            return SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        }finally{
            readLock.unlock();
        }
    }

    public SQLiteDatabase getWritableDataBase(String databaseDirPath,String databaseFileName) {

        writeLock.lock();

        try {
            String databasePath = databaseDirPath.concat(databaseFileName);

            return SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        } finally{
            writeLock.unlock();
        }
    }
}
