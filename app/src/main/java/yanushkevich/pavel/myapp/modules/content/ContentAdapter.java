package yanushkevich.pavel.myapp.modules.content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.realm.RealmResults;
import yanushkevich.pavel.myapp.R;
import yanushkevich.pavel.myapp.models.Person;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder>{

    private RealmResults<Person> personsList;
    private Context context;

    public ContentAdapter(final Context context, final RealmResults<Person> personsList) {
        this.context = context;
        this.personsList = personsList;
    }

    public void updateData(final RealmResults<Person> personsList) {
        this.personsList = personsList;
        notifyDataSetChanged();
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ContentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        final Person person = personsList.get(position);
        holder.firstName.setText(person.getFirstName());
        holder.lastName.setText(person.getLastName());
        holder.childCount.setText(String.valueOf(person.getChildCount()));
        holder.age.setText(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        if (personsList != null){
            return personsList.size();
        } else {
            return 0;
        }
    }



    class ContentViewHolder extends RecyclerView.ViewHolder{

        private TextView firstName;
        private TextView lastName;
        private TextView childCount;
        private TextView age;

        ContentViewHolder(View itemView){
            super(itemView);
            this.firstName = (TextView) itemView.findViewById(R.id.firstname_txv);
            this.lastName = (TextView) itemView.findViewById(R.id.lastname_txv);
            this.childCount = (TextView) itemView.findViewById(R.id.childcount_txv);
            this.age = (TextView) itemView.findViewById(R.id.age_txv);
        }
    }
}
