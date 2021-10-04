package visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentDirectory = "";

    @Override
    public void visit(File file) {
        System.out.println(currentDirectory + "/" + file.getName());
    }

    @Override
    public void visit(Directory directory) {
        String saveDirectory = currentDirectory;
        currentDirectory = currentDirectory + "/" + directory.getName();
        System.out.println(currentDirectory);
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            entry.accept(this);
        }
        currentDirectory = saveDirectory;
    }

}
