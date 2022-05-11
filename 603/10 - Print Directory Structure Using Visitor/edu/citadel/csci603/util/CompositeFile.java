package edu.citadel.csci603.util;

/**
 * This class represents the leaf part of a tree structure
 */
public class CompositeFile extends CompositeFileSystem {

    public CompositeFile(String name) {
        super(name);
    }

    public boolean isFolder() {
        return false;
    }

}