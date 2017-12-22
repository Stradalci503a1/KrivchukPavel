import java.rmi.AccessException;

public class LockerLockedException extends AccessException  {

    public LockerLockedException (){
        super("Locker is locked");
    }
}
