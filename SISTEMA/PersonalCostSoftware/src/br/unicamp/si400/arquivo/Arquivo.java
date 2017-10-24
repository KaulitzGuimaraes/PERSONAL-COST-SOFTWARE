/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class Arquivo {

    private static final Logger LOG = Logger.getLogger(Arquivo.class.getName());
    private final String SERIAL_FILENAME;
    private final Path serizableArchive;

    public Arquivo(String nameFile) {
        LOG.setLevel(Level.INFO);
        this.SERIAL_FILENAME = nameFile;
        this.serizableArchive = FileSystems.getDefault().getPath(SERIAL_FILENAME);
    }

    public <T> T load(T classe) {
        if (Files.exists(serizableArchive)) {
            LOG.info("Usando " + serizableArchive.toString());
            return loadSerialized(classe);
        } else {
            return null;
        }
    }

    private <T> T loadSerialized(T classe) {
        ObjectInputStream fileStream;
        classe = null;
        try {
            fileStream = new ObjectInputStream(
                    Files.newInputStream(serizableArchive));
            classe = (T) fileStream.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            LOG.log(Level.SEVERE, "loadSerialized", ex);
        }
        return classe;
    }

}