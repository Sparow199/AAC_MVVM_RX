package com.lahzouz.sparow.acc_rxjava.viewmodel;

import android.app.Application;

import com.lahzouz.sparow.acc_rxjava.service.database.AppDatabase;
import com.lahzouz.sparow.acc_rxjava.service.model.Project;
import com.lahzouz.sparow.acc_rxjava.service.repository.ProjectRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Single;

public class ProjectListViewModel {

     // private final Single<List<Project>> projectListObservable;
     private final Single<List<Project>> projectListRoomObservable;
     private AppDatabase appDatabase;
     private Project pj1 = new Project(1,"test0","test0", new Date(), new Date(),"url", "Java", 1, 1,"test");
     private Project pj2 = new Project(2,"test1","test1", new Date(), new Date(),"url", "Kotlin", 2, 2,"test");
     private Project pj3 = new Project(3,"test2","test2", new Date(), new Date(),"url", "Java", 3, 3,"test");

    public ProjectListViewModel(Application application) {

        // If any transformation is needed, this can be simply done by Transformations class ...
        // projectListObservable = ProjectRepository.getInstance().getProjectList("Facebook");
        appDatabase = AppDatabase.getAppDatabase(application.getApplicationContext());
        appDatabase.ProjectModel().insertOne(pj1);
        appDatabase.ProjectModel().insertOne(pj2);
        appDatabase.ProjectModel().insertOne(pj3);


        projectListRoomObservable = appDatabase.ProjectModel().getAll();
        //projectListObservable = ProjectRepository.getInstance().getProjectList("Facebook");

    }
    
    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */

//    public Single<List<Project>> getProjectListObservable() {
//        return projectListObservable;
//    }

    public Single<List<Project>> getProjectListObservable() {
        return projectListRoomObservable;
    }
}
