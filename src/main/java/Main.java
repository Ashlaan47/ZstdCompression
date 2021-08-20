public class Main {
    public static void main(String []args) {
        ZstdOperations zstdOperations = new ZstdOperations();
        zstdOperations.compress();
        zstdOperations.decompress();
    }
}
