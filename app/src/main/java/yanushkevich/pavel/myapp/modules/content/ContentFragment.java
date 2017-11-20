package yanushkevich.pavel.myapp.modules.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import yanushkevich.pavel.myapp.R;
import yanushkevich.pavel.myapp.helpers.RealmHelper;

public class ContentFragment  extends Fragment {

    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_content, null);
        if (view != null){
            recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
            contentAdapter = new ContentAdapter(getActivity(), RealmHelper.getPersonsSortedByAge());
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            recyclerView.setAdapter(contentAdapter);
            recyclerView.setLayoutManager(llm);
        }
        return view;
    }

    public void updateData(final String query) {
        contentAdapter.updateData(RealmHelper.getPersonsByContainsQuery(query));
    }
}