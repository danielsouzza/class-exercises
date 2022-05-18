public class Memory {
    static private int size = 16;
    private Integer[] memory_vector;

    public Memory() {
        this.memory_vector = new Integer[size];
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

    public Integer[] getRam(){
        return this.memory_vector;
    }

    public int getSize(){
        return size;
    }

}
