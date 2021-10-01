package composite;

public abstract class Entry {
    protected Entry parent;

    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

    public String getFullPath() {
        StringBuilder fullPath = new StringBuilder();
        Entry entry = this;
        do {
            fullPath.insert(0, "/" + entry.getName());
            entry = entry.parent;
        } while (entry != null);
        return fullPath.toString();
    }

}