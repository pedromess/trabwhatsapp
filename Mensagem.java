
import java.io.Serializable;
import java.util.Calendar;



public class Mensagem implements Serializable {
    private String emissor;
    private String texto;
    private String status;
    private Calendar dataHora;
    

    public Mensagem(String emissor, String texto, Calendar dataHora) {
        this.emissor = emissor;
        this.texto = texto;
        this.dataHora = dataHora;
        this.status="Está sendo enviada";
    }

    public String getEmissor() {
        return emissor;
    }

    public String getTexto() {
        return texto;
    }

    public String getStatus() {
        return status;
    }

    public Calendar getDataHora() {
        return dataHora;
    }
    
    //Valida o Status da mensagem
    public void setStatus(String status) {
        if(status.equalsIgnoreCase("está sendo enviada")||
                status.equalsIgnoreCase("foi enviada")||
                status.equalsIgnoreCase("foi recebida")||
                status.equalsIgnoreCase("foi lida")){
        this.status = status;
        }else{
            System.out.println("ERRO FOX SPORTS");
        }
    }
    
    @Override
    public String toString(){
        String s;
        if(dataHora.get(Calendar.MINUTE)<10){
            s = dataHora.get(Calendar.HOUR_OF_DAY)+":0"+dataHora.get(Calendar.MINUTE);
        }else{
            s = dataHora.get(Calendar.HOUR_OF_DAY)+":"+dataHora.get(Calendar.MINUTE);
        }
        return emissor+" diz:\n"+texto+"\n"+s+" - "+status+"\n";
    }
    
}
