package edu.citadel.csci603.util;

public class CompositeFile extends CompositeFileSystem {

    public CompositeFile(String name) {
        super(name);
    }

    public boolean isFolder() {
        return false;
    }

}