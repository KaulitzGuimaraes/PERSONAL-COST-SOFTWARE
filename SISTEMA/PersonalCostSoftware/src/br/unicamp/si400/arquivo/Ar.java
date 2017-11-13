/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class Ar {
        private static final Logger LOG = Logger.getLogger(Ar.class.getName());
        private final String SERIAL_FILENAME = "arch.dat" ;
        private final Path serizableArchive;

    /**
     *
     */
    public Ar() {
        LOG.setLevel(Level.INFO);
        
        this.serizableArchive = FileSystems.getDefault().getPath(SERIAL_FILENAME);
        
        
    }

    /**
     *
     * @param <T>
     * @param classe
     * @return
     * @throws IOException
     */
    public <T> T load(T classe) throws IOException {
        if (Files.exists(serizableArchive)) {
           
           LOG.info("Usando " + serizableArchive.toString());
            return loadSerialized(classe);
        } else {
            return null;
        }
        
    }

    /**
     *
     * @param <T>
     * @param dados
     */
    public <T> void save(T dados) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
             Files.newOutputStream(serizableArchive));
            os.writeObject(dados);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "save", ex);
        }
    }

    /**
     *
     */
    public  void delete () {
        try {
           Files.delete(serizableArchive);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "delete", ex);
        }
    }
    private <T> T loadSerialized(T classe) {
        ObjectInputStream fileStream;
        
        try {
            fileStream = new ObjectInputStream(
            Files.newInputStream(serizableArchive));
            
            classe = (T) fileStream.readObject();
            
           System.out.print( classe.getClass());
        } catch (ClassNotFoundException | IOException ex) {
            LOG.log(Level.SEVERE, "loadSerialized", ex);
        }
        return classe;
    }
}
