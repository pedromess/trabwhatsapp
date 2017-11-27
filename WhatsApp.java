
import java.io.Serializable;
import java.util.ArrayList;


public class WhatsApp implements Serializable{
    private ArrayList <Conversa> listaConversa = new ArrayList();
    private String nomeUsuario="Zezinho";
    private String telUsuario="989765024";
    private String statusUsuario;
    

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public ArrayList<Conversa> getListaConversa() {
        return listaConversa;
    }

    public String getTelUsuario() {
        return telUsuario;
    }

    //Cria uma nova conversa com um novo contato
    public void iniciarConversa(String telContato){
        Conversa c = new Conversa();
        c.setContato(telContato);
        listaConversa.add(c);
    }
    
    //Envia uma nova mensagem
    public void enviarMensagem(String telContato, String texto){
        receberMensagem(telContato, texto);
    }
    
    //Chama o metodo adicionarMensagem do contato da classe Conversa
    public void receberMensagem(String telContato, String texto){
        for (int i = 0; i < listaConversa.size(); i++) {
            if(listaConversa.get(i).getContato().equals(telContato)){
            listaConversa.get(i).adicionarMensagem(telUsuario, texto);
            }
        }
    }
    
    
    //Retorna o nome do último contato adicionado
    public String buscarContato(String nome){
        String retorno="";
        for (int i = 0; i < listaConversa.size(); i++) {
            if(nome.equals(listaConversa.get(i).getContato())){
                retorno += listaConversa.get(i).listar();
                return retorno;
            }
        }
        return null;
    }
    
    //Procura pelo contato com o nome passado e retorna o objeto Conversa
    public Conversa buscarContatoDois(String nome){
        for (int i = 0; i < listaConversa.size(); i++) {
            if(nome.equals(listaConversa.get(i).getContato())){
                return listaConversa.get(i);
            }
        }
        return null;
    }
    
    
    //Procura pelo contato com o nome passado e retorna o atributo Nome em String
    public String buscarContatoTres(String nome){
        for (int i = 0; i < listaConversa.size(); i++) {
            if(nome.equals(listaConversa.get(i).getContato())){
                return listaConversa.get(i).getContato();
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String retorno="";
        for (int i = 0; i < listaConversa.size(); i++) {
            retorno = listaConversa.get(i).getContato();
        }
        return retorno;
    }
    
}
