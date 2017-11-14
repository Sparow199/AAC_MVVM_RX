package com.lahzouz.sparow.aac.service.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.lahzouz.sparow.aac.service.model.Project;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by sparow on 10/31/17.
 */

@Dao
public interface ProjectDao {
    /***********************************************************************************************
     * Etape == 01 -->> prochaine étape -->> ProjectRepository
     **********************************************************************************************/
    @Query("SELECT * FROM project")
    LiveData<List<Project>> getAll();

    @Query("SELECT *FROM project WHERE project_name = :projectName LIMIT 1")
    LiveData<Project>findOneProject(String projectName);
    /***********************************************************************************************
     **********************************************************************************************/

    @Query("SELECT * FROM project WHERE id IN (:projectIds)")
    List<Project> loadAllByIds(int[] projectIds);

    @Insert(onConflict = REPLACE)
    void insertOne(Project project);

    @Insert(onConflict = REPLACE)
    void insertAll(List<Project> projects);

    @Delete
    void delete(Project project);
}