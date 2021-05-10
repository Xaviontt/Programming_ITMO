package utilities;

import general.*;
import exceptions.*;

import java.time.*;
import java.util.*;

public class CollectionManager {
    private HashMap<Integer, StudyGroup> hashMap = new HashMap<>();
    private FileManager fileManager;
    private LocalDate lastInitTime;
    private Creator creator;

    public CollectionManager(FileManager fileManager, Creator creator) {
        this.fileManager = fileManager;
        this.creator = creator;
    }

    public void clear() {
        hashMap.clear();
    }

    public void insertNew(Integer key, StudyGroup studyGroup) {
        hashMap.put(key, studyGroup);
        lastInitTime = LocalDate.now();
    }

    public String getStringElements() {
        String elements = "";
        if (hashMap.isEmpty())
            System.out.println("Collection is empty :(");
        for (Map.Entry<Integer, StudyGroup> map : hashMap.entrySet()) {
            StudyGroup studyGroup = map.getValue();
            Integer key = map.getKey();
            elements += "Key:" + key + "\n" + studyGroup.toString() + "\n";
        }
        return elements;
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
    public Integer newId() {
        if (hashMap.isEmpty()) return 1;
        int lastId = 0;
        for (StudyGroup s : hashMap.values()) {
            lastId = Math.max(lastId, s.getId());
        }
        return lastId + 1;
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
            System.out.println("\u001B[37m" + "\u001B[33m" + "Элемент с ключом " + key + " успешно удален" + "\u001B[33m" + "\u001B[37m");
        } catch (KeyException e) {
            System.err.println("Элемента с таким ключом не существует");
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
     * Проверяет, есть ли в коллекции элемент с данным ключом
     *
     * @param key ключ
     * @throws NullPointerException если ключ есть
     */
    public void Key(Integer key) {
        if (hashMap.containsKey(key)) {
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
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            boolean checker = false;
            if (e.getValue().getId().equals(id)) {
                checker = true;

            }
            if (checker = false) throw new NullPointerException();
        }
    }


    public int countStudents(Long students) {
        int count = 0;

        for (StudyGroup s : hashMap.values()) {
            if (s.getStudentsCount() == students) {

                count += 1;
            }
        }
        return count;
    }

    /**
     * Заменяет значение по ключу, если оно больше
     *
     * @param key ключ
     */
    public void replaceIfGreater(Integer key) {
        try {
            StudyGroup studyGroup = new StudyGroup(hashMap.get(key).getId(), creator.newStudyGroup(), creator.newCoordinates(), LocalDate.now(), creator.newStudentsCount(), creator.newExpelledStudents(), creator.newAverageMark(), creator.newSemester(), creator.newGroupAdmin());
            if (hashMap.get(key).compareTo(studyGroup) < 0) {
                hashMap.put(key, studyGroup);
                System.out.println("\u001B[37m" + "\u001B[33m" + "Группа с ключом " + key + " была успешно заменена" + "\u001B[33m" + "\u001B[37m");

            } else {
                System.out.println("\u001B[37m" + "\u001B[33m" + "Группа с ключом " + key + " не была заменена, так как меньше или равна уже существующей" + "\u001B[33m" + "\u001B[37m");
            }
        } catch (NullPointerException e) {
            System.err.println("Элемента с таким ключом не существует");
        }
    }

    public int removeGreater(Integer number) {
        List<Integer> a = new ArrayList<>();
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            if (e.getValue().getStudentsCount() > number) {

                a.add(e.getKey());
            }
        }

        for (Integer i : a) {
            hashMap.remove(i);
        }
        return a.size();
    }

    public int removeLower(Integer number) {
        List<Integer> a = new ArrayList<>();
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            if (e.getValue().getStudentsCount() < number) {

                a.add(e.getKey());
            }
        }

        for (Integer i : a) {
            hashMap.remove(i);
        }
        return a.size();
    }

    /**
     * Находит ключ элемента по его ID
     *
     * @param id id
     * @return ключ
     */
    public Integer getKeyById(Integer id) {
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            if (e.getValue().getId().equals(id)) return e.getKey();
        }
        return null;
    }

    /**
     * Заменяет элемент по ключу
     *
     * @param key        ключ
     * @param studyGroup значение
     */
    public void update(Integer key, StudyGroup studyGroup) {
        hashMap.remove(key);
        hashMap.put(key, studyGroup);
    }

    public ArrayList<Long> sortedByStudentsCount() {
        ArrayList<Long> a = new ArrayList<>();
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            a.add(e.getValue().getStudentsCount());
        }
        Collections.sort(a);
        Collections.reverse(a);
        return a;
    }

    public Set<Float> uniqueAverageMark() {
        Set<Float> set = new HashSet<Float>();
        for (Map.Entry<Integer, StudyGroup> e : hashMap.entrySet()) {
            set.add(e.getValue().getAverageMark());
        }
        return set;
    }
}

