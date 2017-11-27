
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ArquivoSerializadoWhats {
    private File f;  

    public ArquivoSerializadoWhats(String nomeArquivo) {
        f = new File(nomeArquivo);
      
    }

    public WhatsApp lerArquivo() {
        WhatsApp wpp;
        if (f.exists()) {
            try (FileInputStream arquivoLeitura = new FileInputStream(f);
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);) {
                wpp = (WhatsApp) objetoLeitura.readObject();
            } catch (Exception ex) {
                System.out.println(ex);
                wpp = new WhatsApp();
            }
        } else {
            System.out.println("Não tinha arquivo");
            wpp = new WhatsApp();
        }
        return wpp;
    }

    public void gravarArquivo(WhatsApp wpp) {
        try (FileOutputStream arquivoGravar = new FileOutputStream(f);
                ObjectOutputStream objetoGravar = new ObjectOutputStream(arquivoGravar);) {
            objetoGravar.writeObject(wpp);
            System.out.println("Objeto gravado com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
