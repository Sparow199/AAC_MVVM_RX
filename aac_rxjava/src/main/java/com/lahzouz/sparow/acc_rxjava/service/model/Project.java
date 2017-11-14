package com.lahzouz.sparow.acc_rxjava.service.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.lahzouz.sparow.acc_rxjava.service.database.Converters;

import java.util.Date;

@Entity
public class Project {
    @PrimaryKey
    public long id;
    @ColumnInfo(name = "project_name")
    public String name;
    public String description;
    @TypeConverters({Converters.class})
    public Date created_at;
    @TypeConverters({Converters.class})
    public Date updated_at;
    public String git_url;
    @ColumnInfo(name = "programing_langage")
    public String language;
    public int open_issues;
    public int watchers;
    public String clone_url;

    public Project(long id, String name, String description, Date created_at, Date updated_at, String git_url, String language, int open_issues, int watchers, String clone_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.git_url = git_url;
        this.language = language;
        this.open_issues = open_issues;
        this.watchers = watchers;
        this.clone_url = clone_url;
    }

//    public String url;
//    public Date pushed_at;
//    public String svn_url;
//    public String homepage;
//    public String ssh_url;
//    public int stargazers_count;
//    public int watchers_count;
//    public String full_name;
//    public User owner;
//    public String html_url;
//    public boolean has_issues;
//    public boolean has_downloads;
//    public boolean has_wiki;
//    public boolean has_pages;
//    public int forks_count;
//    public int open_issues_count;
//    public int forks;
//    public String default_branch;

    @Ignore
    public Project() {
    }
    @Ignore
    public Project(String name) {
        this.name = name;
    }
}
