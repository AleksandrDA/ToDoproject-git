package com.example.todoproject.FastAddTask;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.todoproject.DataBase.Room.AppDataBase;
import com.example.todoproject.DataBase.Room.StoreObjectDatabase;
import com.example.todoproject.DataBase.Room.Tasks;
import com.example.todoproject.DataBase.Room.TasksDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FastTaskRepository implements FastTaskContract.Repository {

    private static final String TAG = "myLogs";
    private Tasks task = new Tasks();

    //получение Базы данных
    AppDataBase db = StoreObjectDatabase.getInstance().getDatabase();
    //из Database объекта получаем Dao
    TasksDao tasksDao = db.tasksDao();

    @Override
    public void onSaveTaskDB(String nameTask) {
        //передача nameTask в DataBaseSQLite (бд на голом SQLite)
        /*dataBase = new DataBaseSQLite(AppContext.getContext());
        dataBase.insertData(nameTask);*/

        task.setTaskName(nameTask);
        tasksDao.insertTask(task);

        //передача всех задач которые есть в БД (в столбце task_name) в MainPresenter
        /*List<Tasks> allTasks = tasksDao.getAll();
        mainPresenter = new MainPresenter(onReceived);
        mainPresenter.onPassTaskMainView(allTasks);*/

        Log.d(TAG,"onSaveTaskDB work in class FastTaskRepository " + task + Thread.currentThread().getName());
    }
}

