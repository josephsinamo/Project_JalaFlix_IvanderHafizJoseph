public class UmurNegatifException extends RuntimeException {

    public UmurNegatifException() {
        super("Kesalahan: Umur tidak boleh bernilai negatif!");
    }

    public UmurNegatifException(int umur) {
        super("Input umur tidak valid: " + umur + ". Umur harus 0 atau lebih.");
    }
}