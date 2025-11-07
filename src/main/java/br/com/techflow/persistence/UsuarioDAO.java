package br.com.techflow.persistence;

import java.io.File;
import br.com.techflow.model.UsuarioDatabase;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class UsuarioDAO {

    private static final String FILE_PATH = "usuarios.xml";

    /**
     * Carrega o banco de dados de usuários do arquivo XML.
     * Se o arquivo não existir, retorna um novo banco de dados vazio.
     */
    public UsuarioDatabase carregar() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new UsuarioDatabase(); // Retorna banco vazio se o arquivo não existe
        }

        try {
            JAXBContext context = JAXBContext.newInstance(UsuarioDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (UsuarioDatabase) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            System.err.println("Erro ao carregar XML: " + e.getMessage());
            return new UsuarioDatabase(); // Retorna banco vazio em caso de erro
        }
    }

    /**
     * Salva o estado atual do banco de dados no arquivo XML.
     */
    public void salvar(UsuarioDatabase database) {
        try {
            JAXBContext context = JAXBContext.newInstance(UsuarioDatabase.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Para o XML ficar bonito

            File file = new File(FILE_PATH);
            marshaller.marshal(database, file);
        } catch (Exception e) {
            System.err.println("Erro ao salvar XML: " + e.getMessage());
        }
    }
}