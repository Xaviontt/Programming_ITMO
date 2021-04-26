package utilities;

import exceptions.*;
import general.StudyGroup;
import xml.StudyGroups;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.*;

/**
 * Operates the file for saving/loading collection.
 */
public class FileManager {
    private final String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    private BufferedInputStream getBufferedInputStream() throws FileNotFoundException, FileException {
        File file = new File(System.getenv(envVariable));
        if (file.exists() && !file.canRead())
            System.err.println("Недостаточно прав для чтения файла");
        return new BufferedInputStream(new FileInputStream(file));
    }

    private FileWriter getFileWriter() throws IOException, FileException {
        File file = new File(System.getenv(envVariable));
        if (file.exists() && !file.canWrite())
            System.err.println("Недостаточно прав для чтения файла");
        return new FileWriter(new File(System.getenv(envVariable)));
    }

    /**
     * Writes collection to a file.
     *
     * @param collection Collection to write.
     */
    public void writeCollection(HashMap<Integer, StudyGroup> collection) {
        if (System.getenv().get(envVariable) != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(StudyGroups.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                StudyGroups result = new StudyGroups();
                result.setStudyGroups(collection);
                marshaller.marshal(result, getFileWriter());

                System.out.println("Коллекция успешна сохранена в файл!");
            } catch (JAXBException | IOException e) {
                System.err.println("Ошибка сохранения в файл!");
            } catch (FileException e) {
                System.err.println("Нет доступа к файлу!");
            }
        } else System.err.println("Системная переменная с загрузочным файлом не найдена!");
    }

    /**
     * Reads collection from a file.
     *
     * @return Readed collection.
     */
    public HashMap<Integer, StudyGroup> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(StudyGroups.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                unmarshaller.unmarshal(getBufferedInputStream());
                StudyGroups studyGroups = (StudyGroups) unmarshaller.unmarshal(new File(System.getenv(envVariable)));
                HashMap<Integer, StudyGroup> collection = studyGroups.getStudyGroups();
                System.out.println("Коллекция успешно загружена!");
                return collection;
            } catch (NoSuchElementException exception) {
                System.err.println("Загрузочный файл пуст!");
            } catch (NullPointerException exception) {
                System.err.println("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException exception) {
                System.err.println("Непредвиденная ошибка!");
            } catch (JAXBException e) {
                System.err.println("Ошибка прочтения XML-файла");
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                System.err.println("Файл не найден");
            } catch (FileException e) {
                System.err.println("Нет доступа к файлу!");
            }
        } else System.err.println("Системная переменная с загрузочным файлом не найдена!");
        System.out.println("Проверьте переменную окружения " + envVariable + " и запустите заново.");
        System.exit(0);
        return new HashMap<>();
    }
}