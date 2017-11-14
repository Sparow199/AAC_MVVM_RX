package com.lahzouz.sparow.acc_rxjava.service.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.lahzouz.sparow.acc_rxjava.service.model.Project;

import java.util.List;

import io.reactivex.Single;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by sparow on 10/31/17.
 */

@Dao
public interface ProjectDao {
    @Query("SELECT * FROM project")
    Single<List<Project>> getAll();

    @Query("SELECT *FROM project WHERE project_name = :projectName LIMIT 1")
    Single<Project>findOneProject(String projectName);

    @Query("SELECT * FROM project WHERE id IN (:projectIds)")
    List<Project> loadAllByIds(int[] projectIds);

    @Insert(onConflict = REPLACE)
    void insertOne(Project project);

    @Insert(onConflict = REPLACE)
    void insertAll(List<Project> projects);

    @Delete
    void delete(Project project);
}