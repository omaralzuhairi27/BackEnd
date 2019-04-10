public class LargerEightChars implements Verification {
    @Override
    public boolean isValid(String password) {
        return password.length() > 8;
    }
}
