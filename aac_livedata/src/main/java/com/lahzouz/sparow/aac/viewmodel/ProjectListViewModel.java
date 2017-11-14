package com.lahzouz.sparow.aac.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.CountDownTimer;

import com.lahzouz.sparow.aac.service.database.AppDatabase;
import com.lahzouz.sparow.aac.service.model.Project;
import com.lahzouz.sparow.aac.service.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {

    private LiveData<List<Project>> projectListObservable;
    private AppDatabase appDatabase;
    private Project pj1 = new Project(1,"test0","test0", new Date(), new Date(),"url", "Java", 1, 1,"test");
    private Project pj2 = new Project(2,"test1","test1", new Date(), new Date(),"url", "Kotlin", 2, 2,"test");
    private Project pj3 = new Project(3,"test2","test2", new Date(), new Date(),"url", "Java", 3, 3,"test");
    private List<Project> projects = new ArrayList<>();

    public ProjectListViewModel(Application application) {
        super(application);
        projects.add(pj1);
        projects.add(pj2);
        // If any transformation is needed, this can be simply done by Transformations class ...
        appDatabase = AppDatabase.getAppDatabase(this.getApplication());
        appDatabase.ProjectModel().insertAll(projects);

        new CountDownTimer(15000, 5000) {

            @Override
            public void onTick(long l) {
                    appDatabase.ProjectModel().insertOne(pj3);
            }
            @Override
            public void onFinish() {
                appDatabase.ProjectModel().delete(pj3);
            }
        }.start();


    /***********************************************************************************************
     * Etape == 03 -->> prochaine étape -->> ProjectViewModel
     **********************************************************************************************/
//        // uncomment to switch to local database mode
//        projectListObservable = appDatabase.ProjectModel().getAll();
//
//        // uncomment to switch to Remote repository mode
////        projectListObservable = ProjectRepository.getInstance().getProjectList("Apolline-Lille");
    /***********************************************************************************************
     **********************************************************************************************/
    }


    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;}
}
