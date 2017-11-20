package yanushkevich.pavel.myapp.helpers;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import yanushkevich.pavel.myapp.models.Person;

public class RealmHelper {

    public static void checkDBIsNotEmpty(){
        if(Realm.getDefaultInstance().where(Person.class).count()==0){
            MockHelper.mockRealm();
        }
    }

    public static RealmResults<Person> getPersonsSortedByAge(){
        return Realm.getDefaultInstance().where(Person.class).findAllSorted("age", Sort.DESCENDING);
    }

    public static RealmResults<Person> getPersonsByContainsQuery(final String queryString) {
        if(queryString.length() > 0) {
            return Realm.getDefaultInstance().where(Person.class).contains("firstName", queryString, Case.INSENSITIVE).findAllSorted("age", Sort.DESCENDING);
        } else {
            return getPersonsSortedByAge();
        }
    }
}
