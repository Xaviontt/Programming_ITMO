package utility.commands;

import common.general.StudyGroup;

import java.util.Objects;

public abstract class AbstractCommand {
    private String name;
    private String description;

    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean execute(String argument, StudyGroup studyGroup);

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && description.equals(other.description);
    }
}

