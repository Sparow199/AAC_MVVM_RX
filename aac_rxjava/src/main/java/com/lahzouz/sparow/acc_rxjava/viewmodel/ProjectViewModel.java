package com.lahzouz.sparow.acc_rxjava.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.lahzouz.sparow.acc_rxjava.service.database.AppDatabase;
import com.lahzouz.sparow.acc_rxjava.service.model.Project;
import com.lahzouz.sparow.acc_rxjava.service.repository.ProjectRepository;

import io.reactivex.Single;

public class ProjectViewModel {

    private AppDatabase appDatabase;
    private final Single<Project> projectObservable;
    private final String projectID;

    public ObservableField<Project> project = new ObservableField<>();

    public ProjectViewModel(@NonNull Application application,
                            final String projectID) {
        //super(application);
        this.projectID = projectID;

        //projectObservable = ProjectRepository.getInstance().getProjectDetails("Facebook", projectID);

        appDatabase = AppDatabase.getAppDatabase(application.getApplicationContext());
        projectObservable = appDatabase.ProjectModel().findOneProject(projectID);

        // projectObservable = ProjectRepository.getInstance().getProjectDetails("Facebook", projectID);
    }

    public Single<Project> getObservableProject() {
        return projectObservable;
    }

    public void setProject(Project project) {
        this.project.set(project);
    }

}
