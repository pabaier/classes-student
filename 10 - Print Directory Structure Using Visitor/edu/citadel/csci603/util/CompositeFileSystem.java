package edu.citadel.csci603.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public abstract class CompositeFileSystem implements Comparable<CompositeFileSystem> {

    String name;
    CompositeFolder parent;
    List<CompositeFileSystem> contents = new ArrayList<>();


    public CompositeFileSystem(String name) {
        this.name = name;
    }

    public abstract boolean isFolder();

    public List<CompositeFileSystem> getList() {
        return contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(CompositeFileSystem other) {
        if(this.isFolder() && !other.isFolder())
            return -1;
        else if(!this.isFolder() && other.isFolder())
            return 1;
        else
            return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }

    public String toString() {
        return name;
    }

    private static class SortAlphaAscending implements Comparator<CompositeFileSystem> {
        public int compare(CompositeFileSystem a, CompositeFileSystem b) {
            return a.compareTo(b);
        }
    }

    private static class SortAlphaDescending implements Comparator<CompositeFileSystem> {
        public int compare(CompositeFileSystem a, CompositeFileSystem b) {
            if(a.isFolder() && !b.isFolder())
                return -1;
            else if(!a.isFolder() && b.isFolder())
                return 1;
            else
                return -1 * a.name.toLowerCase().compareTo(b.name.toLowerCase());
        }
    }

    public static Comparator getSortAlphaAscending() {
        return new SortAlphaAscending();
    }

    public static Comparator getSortAlphaDescending() {
        return new SortAlphaDescending();
    }
}