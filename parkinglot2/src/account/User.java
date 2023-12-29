package account;
import java.time.*;

public abstract class User {
    private String id;
    private String email;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
}
