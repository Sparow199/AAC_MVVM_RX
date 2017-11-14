package com.lahzouz.sparow.aac.view.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lahzouz.sparow.aac.R;
import com.lahzouz.sparow.aac.databinding.FragmentProjectListBinding;
import com.lahzouz.sparow.aac.service.model.Project;
import com.lahzouz.sparow.aac.view.adapter.ProjectAdapter;
import com.lahzouz.sparow.aac.view.callback.ProjectClickCallback;
import com.lahzouz.sparow.aac.viewmodel.ProjectListViewModel;

import java.util.List;


public class ProjectListFragment extends Fragment implements LifecycleOwner {
    public static final String TAG = "ProjectListFragment";
    private ProjectAdapter projectAdapter;
    private FragmentProjectListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);

        projectAdapter = new ProjectAdapter(projectClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProjectListViewModel viewModel =
                ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    /***********************************************************************************************
     * Etape == 05 -->> prochaine étape -->> ProjectFragment
     **********************************************************************************************/
//    private void observeViewModel(ProjectListViewModel viewModel) {
//        // Update the list when the data changes
//        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
//            @Override
//            public void onChanged(@Nullable List<Project> projects) {
//                if (projects != null) {
//                    binding.setIsLoading(false);
//                    projectAdapter.setProjectList(projects);
//                }
//            }
//        });
//    }
    /***********************************************************************************************
     **********************************************************************************************/
    private final ProjectClickCallback projectClickCallback = new ProjectClickCallback() {
        @Override
        public void onClick(Project project) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity) getActivity()).show(project);
            }
        }
    };
}