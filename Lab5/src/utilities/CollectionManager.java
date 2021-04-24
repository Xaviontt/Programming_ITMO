package utilities;

import general.StudyGroup;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CollectionManager {
    private HashMap<Integer, StudyGroup> hashMap = new HashMap<>();
    private FileManager fileManager;
    private LocalDateTime lastInitTime;
    private Creator creator;

    public CollectionManager(FileManager fileManager, Creator creator) {
        this.fileManager = fileManager;
        this.creator = creator;
    }

    public void clear() {
        hashMap.clear();
    }

    public void insert(Integer key, StudyGroup studyGroup) {
        hashMap.put(key, studyGroup);
    }

    public String show() {
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

    public LocalDateTime getLastInitTime(){
        return lastInitTime;
    }

    public String collectionType(){
        return hashMap.getClass().getName();
    }

    public int collectionSize(){
        return hashMap.size();
    }
}
