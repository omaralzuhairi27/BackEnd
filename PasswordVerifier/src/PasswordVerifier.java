import java.util.List;

public class PasswordVerifier {
    private List<Verification> verificationList = Verifications.asList();

    public Boolean part1(String password) {
        return verificationList.stream()
                .allMatch(e -> e.isValid(password));
    }

    public boolean part2(String password) {
        if(password==null){
            return false;
        }
        long count = verificationList.stream()
                .filter(e -> e.isValid(password))
                .count();
        if (count >= 3) {
            return true;
        }
        return false;
    }

    public Boolean part3(String password) {
        return verificationList.get(3).isValid(password);
    }
}
