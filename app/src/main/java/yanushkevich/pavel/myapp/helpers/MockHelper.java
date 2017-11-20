package yanushkevich.pavel.myapp.helpers;

import io.realm.Realm;
import yanushkevich.pavel.myapp.models.Person;

public class MockHelper {

    public static void mockRealm(){
        createPerson(1, "Pavel", "Yanushkevich", 0, 25);
        createPerson(2, "Petr", "Pupkin", 2, 14);
        createPerson(3, "Artem", "Ivanov", 1, 28);
        createPerson(4, "Vladimir", "Sidorov", 4, 30);
        createPerson(5, "Vitaliy", "Petrov", 0, 10);
        createPerson(6, "Arseniy", "Vasiliev", 1, 15);
        createPerson(7, "Viacheslav", "Slavonov", 1, 26);
        createPerson(8, "Julia", "Nikolaeva", 1, 44);
        createPerson(9, "Maria", "Marikina", 2, 21);
        createPerson(10, "Daria", "Stavrovich", 0, 18);
    }

    public static void createPerson(long id, String firstName, String lastName, int childCount, int age){
        final Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setChildCount(childCount);
        person.setAge(age);

        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(person);
            }
        });

    }
}
