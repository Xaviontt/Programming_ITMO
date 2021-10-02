package utility.managers;

import common.general.StudyGroup;
import exceptions.KeyException;
import utility.LoggerUtility;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionManager {
    private HashMap<Integer, StudyGroup> hashMap = new HashMap<>();
    private FileManager fileManager;
    private LocalDate lastInitTime;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
        loadCollection();
    }

    public void clear() {
        hashMap.clear();
    }

    public void insertNew(Integer key, StudyGroup studyGroup) {
        hashMap.put(key, studyGroup);
        lastInitTime = LocalDate.now();
    }

    public String getStringElements() {
        if (hashMap.isEmpty())
            LoggerUtility.info("Коллекция пуста");
        return hashMap.entrySet().stream()
                .map(e -> "Key:" + e.getKey() + "\n" + e.getValue().toString())
                .collect(Collectors.joining("\n"));
    }

    public LocalDate getLastInitTime() {
        return lastInitTime;
    }

    public String collectionType() {
        return hashMap.getClass().getName();
    }

    public int collectionSize() {
        return hashMap.size();
    }

    public void saveToFile() {
        fileManager.writeCollection(hashMap);
    }

    /**
     * Читает коллекцию из файла
     */
    public void loadCollection() {
        hashMap = fileManager.readCollection();
        lastInitTime = LocalDate.now();
    }

    /**
     * Генерирует ID
     *
     * @return ID
     */
    public StudyGroup newId(StudyGroup studyGroup) {
        int id;
        if (hashMap.isEmpty())
        {
            id = 1;
        }
        else
        {
            int lastId = hashMap.values()
                    .stream()
                    .map(StudyGroup::getId)
                    .max(Integer::compareTo)
                    .get();
            id = lastId + 1;
        }
        return new StudyGroup(id, studyGroup.getName(), studyGroup.getCoordinates(), studyGroup.getCreationDate(), studyGroup.getStudentsCount(), studyGroup.getExpelledStudents(), studyGroup.getAverageMark(), studyGroup.getSemesterEnum(), studyGroup.getGroupAdmin());
    }

    /**
     * Удаляет элемент по ключу
     *
     * @param key ключ
     */
    public void removeKey(int key) {
        try {
            if (!hashMap.containsKey(key)) throw new KeyException();
            hashMap.remove(key);
            LoggerUtility.info("\u001B[37m" + "\u001B[33m" + "Элемент с ключом " + key + " успешно удален" + "\u001B[33m" + "\u001B[37m");
        } catch (KeyException e) {
            LoggerUtility.error("Элемента с таким ключом не существует");
        }
    }

    /**
     * Проверяет, есть ли в коллекции элемент с данным ключом
     *
     * @param key ключ
     * @throws NullPointerException если ключа нет
     */
    public void checkKey(Integer key) {
        if (!hashMap.containsKey(key)) {
            throw new NullPointerException();
        }

    }

    /**
     * Проверяет, есть ли в коллекции элемент с таким ID
     *
     * @param id id
     * @throws NullPointerException если нет эл-та с таким ID
     */
    public void checkId(Integer id) {
        boolean isFound = hashMap.values()
                .stream()
                .anyMatch(v -> v.getId().equals(id));
        if (!isFound)
        {
            throw new NullPointerException();
        }
    }


    public int countStudents(Long students) {
        return (int) hashMap.values().stream()
                .filter(s -> Objects.equals(s.getStudentsCount(), students))
                .count();
    }

    /**
     * Заменяет значение по ключу, если оно больше
     *
     * @param key ключ
     */
    public void replaceIfGreater(Integer key, StudyGroup studyGroup) {
        try {
//            StudyGroup studyGroup = new StudyGroup(hashMap.get(key).getId(), creator.newStudyGroup(), creator.newCoordinates(), LocalDate.now(), creator.newStudentsCount(), creator.newExpelledStudents(), creator.newAverageMark(), creator.newSemester(), creator.newGroupAdmin());
            if (hashMap.get(key).compareTo(studyGroup) < 0) {
                hashMap.put(key, studyGroup);
                LoggerUtility.info("\u001B[37m" + "\u001B[33m" + "Группа с ключом " + key + " была успешно заменена" + "\u001B[33m" + "\u001B[37m");

            } else {
                LoggerUtility.info("\u001B[37m" + "\u001B[33m" + "Группа с ключом " + key + " не была заменена, так как меньше или равна уже существующей" + "\u001B[33m" + "\u001B[37m");
            }
        } catch (NullPointerException e) {
            LoggerUtility.error("Элемента с таким ключом не существует");
        }
    }

    public int removeGreater(Integer number) {
        return (int) new HashMap<>(hashMap).entrySet().stream()
                .filter(e -> e.getValue().getStudentsCount() > number)
                .map(Map.Entry::getKey)
                .peek(key -> hashMap.remove(key))
                .count();
    }

    public int removeLower(Integer number) {
        return (int) new HashMap<>(hashMap).entrySet().stream()
                .filter(e -> e.getValue().getStudentsCount() < number)
                .map(Map.Entry::getKey)
                .peek(key -> hashMap.remove(key))
                .count();
    }

    /**
     * Находит ключ элемента по его ID
     *
     * @param id id
     * @return ключ
     */
    public Integer getKeyById(Integer id) {
        return hashMap.entrySet().stream()
                .filter(e -> e.getValue().getId().equals(id))
                .map(Map.Entry::getKey).findFirst().orElse(null);
    }

    /**
     * Заменяет элемент по ключу
     *
     * @param key        ключ
     * @param studyGroup значение
     */
    public void update(Integer key, StudyGroup studyGroup) {
        hashMap.remove(key);
        hashMap.put(key, newId(studyGroup));
    }

    public ArrayList<Long> sortedByStudentsCount() {
        return (ArrayList<Long>) hashMap.values().stream()
                .map(StudyGroup::getStudentsCount)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public Set<Float> uniqueAverageMark() {
        return hashMap.values().stream()
                .map(StudyGroup::getAverageMark)
                .collect(Collectors.toSet());
    }
}

