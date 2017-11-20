package yanushkevich.pavel.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import yanushkevich.pavel.myapp.helpers.RealmHelper;
import yanushkevich.pavel.myapp.modules.content.ContentFragment;

public class MainActivity extends AppCompatActivity {

    private ContentFragment contentFragment;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(getSearchListener());

        RealmHelper.checkDBIsNotEmpty();

        contentFragment = new ContentFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
    }

    private SearchView.OnQueryTextListener getSearchListener() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newQuery) {
                if(contentFragment != null) {
                    contentFragment.updateData(newQuery);
                }
                return false;
            }
        };
    }
}
