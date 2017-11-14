package com.lahzouz.sparow.acc_rxjava.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lahzouz.sparow.acc_rxjava.R;
import com.lahzouz.sparow.acc_rxjava.databinding.FragmentProjectDetailsBinding;
import com.lahzouz.sparow.acc_rxjava.service.model.Project;
import com.lahzouz.sparow.acc_rxjava.viewmodel.ProjectViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProjectFragment extends BaseFragment {
    private static final String KEY_PROJECT_ID = "project_id";
    private FragmentProjectDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false);

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProjectViewModel viewModel = new ProjectViewModel(getActivity().getApplication(),
                getArguments().getString(KEY_PROJECT_ID));

        binding.setProjectViewModel(viewModel);
        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }
    /***********************************************************************************************
     * Etape == 08 -->> prochaine étape -->> Félicitations ! c'est fini
     **********************************************************************************************/
//    private void observeViewModel(final ProjectViewModel viewModel) {
//        // Observe project data
//        addDisposable(
//                viewModel.getObservableProject()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<Project>() {
//                            @Override
//                            public void accept(Project project) throws Exception {
//                                binding.setIsLoading(false);
//                                viewModel.setProject(project);
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
    /** Creates project fragment for specific project ID */
    public static ProjectFragment forProject(String projectID) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();

        args.putString(KEY_PROJECT_ID, projectID);
        fragment.setArguments(args);

        return fragment;
    }
}
