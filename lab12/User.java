public class User implements ObserverUser {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notify(String notification) {
        System.out.println(name + " " + notification);
    }
}

class TestObserver {
    public static void main(String[] args) {
        Channel canal = new Channel("Hello world");
        User user1 = new User("Andrei");
        User user2 = new User("Ana");
        User user3 = new User("Alibaba");

        canal.subscribe(user1);
        canal.subscribe(user2);
        canal.subscribe(user3);

        canal.notify("- > AM adaugat un nou video");
    }

}