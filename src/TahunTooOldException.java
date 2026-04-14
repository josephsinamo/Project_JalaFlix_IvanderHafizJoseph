public class TahunTooOldException extends RuntimeException {

    public TahunTooOldException() {
        super("Tahun rilis terlalu lama untuk sistem Jalaflix!");
    }

    public TahunTooOldException(String message) {
        super(message);
    }

}
