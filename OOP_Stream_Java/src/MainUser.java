import java.util.*;

public class MainUser {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Mario", "Rossi", "Napoli", 49));
        userList.add(new User("Giuseppe", "Verdi", "Milano", 31));
        userList.add(new User("Francesca", "Neri", "Napoli", 19));
        userList.add(new User("Antonio", "Bianchi", "Napoli", 25));
        userList.add(new User("Simona", "Gialli", "Roma", 20));

        userList.get(0).getHobby().add("Calcio");
        userList.get(0).getHobby().add("Padel");
        userList.get(1).getHobby().add("Padel");
        userList.get(1).getHobby().add("Calcio");
        userList.get(2).getHobby().add("Calcio");
        userList.get(3).getHobby().add("Golf");
        userList.get(3).getHobby().add("Calcio");
        userList.get(4).getHobby().add("Tennis");

//        List<User> userListFiltrata = new ArrayList<User>();
//        for(User u:userList) {
//            if(u.getAge() > 29) {
//                userListFiltrata.add(u);
//            }
//        }

        List<User> userListFiltrata2 =userList.stream().filter(u -> u.getAge() > 29).toList();
        OptionalDouble age = userList.stream()
                //.forEach(System.out::println);
                .mapToInt(User::getAge)
                //.forEach(System.out::println);
                //.max()
                //.min()
                //.sum()
                .average();
        System.out.println(age.getAsDouble());

        userList.stream()
                .flatMap(u -> u.getHobby().stream())
                .distinct()
                .forEach(System.out::println);

    }
}
