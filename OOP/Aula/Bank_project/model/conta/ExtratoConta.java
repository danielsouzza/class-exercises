package model.conta;
import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;

public class ExtratoConta implements Serializable{
  private List<ExtratoItem> extrato;
  public ExtratoConta(){
    this.extrato = new ArrayList<>();
  }


  public void addLancamento(ExtratoItem lancamento){
    this.extrato.add(lancamento);
  }

  public List<ExtratoItem> getExtrato(){
    return new ArrayList<>(this.extrato);
  }
  
  public List<ExtratoItem> getExtrato(String date) throws DataInvalidaException{
    List<ExtratoItem> extrato = new ArrayList<>();
    for(ExtratoItem item : this.extrato){
       if(date.equals(item.getData())){
        extrato.add(item);
       }
    }
    if(extrato.isEmpty()){
      throw new DataInvalidaException(date);
    }
    return new ArrayList<>(extrato);
  }

}