
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public class Conversa implements Serializable{
    private ArrayList <Mensagem> listaMensagem = new ArrayList();
    private String contato;
    private Calendar online = Calendar.getInstance();
    
    //Cria e adiciona uma nova Mensagem na conversa
    public void adicionarMensagem(String autor, String texto){
        Calendar dataHora = Calendar.getInstance();
        Mensagem msg = new Mensagem(autor, texto, dataHora);
        listaMensagem.add(msg);
    }

    public ArrayList<Mensagem> getListaMensagem() {
        return listaMensagem;
    }
    

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Calendar getOnline() {
        return online;
    }

    public void setOnline(Calendar online) {
        this.online = online;
    }
    
    
    //Retorna todas as mensagens em formato String
    public String listar(){
        String retorno="";
        for (int i = 0; i < listaMensagem.size(); i++) {
            retorno +=listaMensagem.get(i).toString()+"\n";
        }
        return retorno;
    }
    
    //Retorna um ArrayList de Mensagem com todas as mensagens
    //que contém a palavra passada por parametro
    public ArrayList<Mensagem> buscarPalavra(String palavra){
        ArrayList<Mensagem> retorno = new ArrayList();
        for (int i = 0; i < listaMensagem.size(); i++) {
            String[] quebraMensagem = listaMensagem.get(i).getTexto().split(" ");
            for (int j = 0; j < quebraMensagem.length; j++) {
                if(quebraMensagem[j].equalsIgnoreCase(palavra)){
                    retorno.add(listaMensagem.get(i));
                }
            }
        }
        return retorno;
    }
    
}
