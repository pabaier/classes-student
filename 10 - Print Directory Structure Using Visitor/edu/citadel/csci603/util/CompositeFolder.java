package edu.citadel.csci603.util;

/**
 * This class represents the composite part of a tree structure
 */
public class CompositeFolder extends CompositeFileSystem {


    public CompositeFolder(String name) {
        super(name);
    }

    public CompositeFolder getParent() {
        return parent;
    }

    public void setParent(CompositeFolder parent) {
        this.parent = parent;
    }

    public boolean isFolder() {
        return true;
    }

    public void add(CompositeFileSystem c) {
        contents.add(c);
        if(c.isFolder())
            c.parent = this;
    }


    public CompositeFileSystem getItem(int i) {
        try {
            CompositeFileSystem item = contents.get(i);
            return item;
        }
        catch(Exception e) {
            return null;
        }
    }
}