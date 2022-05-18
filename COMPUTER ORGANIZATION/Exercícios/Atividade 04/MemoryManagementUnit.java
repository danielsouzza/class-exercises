import java.util.Arrays;

public class MemoryManagementUnit {
    private Memory memory;

    public MemoryManagementUnit(){
        this. memory = new Memory();
    }

    public void write(int mbr) throws MemoryManagementUnitException{
        int mar = Arrays.asList(memory.getRam()).indexOf(0);
        if(mar == -1 ){
            throw new MemoryManagementUnitException("Memoria insuficiente !!");
        } else {
            this.memory.write(mar, mbr);
        }
    }

    public Integer[] read(){
        return this.memory.getRam();
    }

    public int read(int mar) throws MemoryManagementUnitException {
        if(mar < memory.getSize()){
            return this.memory.read(mar);
        } else {
            throw new MemoryManagementUnitException("Endereço muito grande");
        }
    }

    public int getSize(){
        return this.memory.getSize();
    }
}

class MemoryManagementUnitException extends Exception {
    public MemoryManagementUnitException(String erro){
        super(erro);
    }
}
