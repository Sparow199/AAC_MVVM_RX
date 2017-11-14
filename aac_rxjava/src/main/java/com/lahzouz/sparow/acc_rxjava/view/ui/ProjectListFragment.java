package com.lahzouz.sparow.acc_rxjava.view.ui;

import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lahzouz.sparow.acc_rxjava.R;
import com.lahzouz.sparow.acc_rxjava.databinding.FragmentProjectListBinding;
import com.lahzouz.sparow.acc_rxjava.service.model.Project;
import com.lahzouz.sparow.acc_rxjava.view.adapter.ProjectAdapter;
import com.lahzouz.sparow.acc_rxjava.view.callback.ProjectClickCallback;
import com.lahzouz.sparow.acc_rxjava.viewmodel.ProjectListViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProjectListFragment extends BaseFragment {
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
        final ProjectListViewModel viewModel = new ProjectListViewModel(getActivity().getApplication());
        //ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }
    /***********************************************************************************************
     * Etape == 07 -->> prochaine étape -->> ProjectFragment
     **********************************************************************************************/
//    private void observeViewModel(ProjectListViewModel viewModel) {
//        // Update the list when the data changes
//        addDisposable(
//                viewModel.getProjectListObservable()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<List<Project>>() {
//                            @Override
//                            public void accept(List<Project> projects) throws Exception {
//                                binding.setIsLoading(false);
//                                projectAdapter.setProjectList(projects);
//                            }
//                        }, new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//                                Log.d("ERROR", "An error happens");
//                            }
//                        })
//        );
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
