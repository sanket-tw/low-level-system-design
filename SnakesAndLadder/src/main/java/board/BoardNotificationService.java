package board;

public interface BoardNotificationService {
     default void notify(String s) {
        System.out.println(s);
    }
}
