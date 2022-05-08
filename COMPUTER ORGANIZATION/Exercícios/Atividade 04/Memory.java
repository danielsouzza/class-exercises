public class Memory {
    static private int size = 1024;
    private int[] memory_vector;

    public Memory() {
        this.memory_vector = new int[size];
        size = memory_vector.length;
        for (int i = 0; i < size; i++) {
            this.memory_vector[i] = 0;
        }
    }

    public void write(int mar, int mbr) {
        this.memory_vector[mar] = mbr;
    }

    public int read(int mar){
        return this.memory_vector[mar];
    }

}
