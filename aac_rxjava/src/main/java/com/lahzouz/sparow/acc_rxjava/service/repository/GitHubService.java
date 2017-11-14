package com.lahzouz.sparow.acc_rxjava.service.repository;

import com.lahzouz.sparow.acc_rxjava.service.model.Project;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GitHubService {
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Single<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Single<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
