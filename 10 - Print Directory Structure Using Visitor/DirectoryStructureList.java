package edu.citadel.csci603.util;

import java.util.ArrayList;

public class DirectoryStructureList<T> {
    private ArrayList<DirectoryStructureList> directoryStructureList;
    private ArrayList<T> directoryList;

    public DirectoryStructureList() {
        directoryList = new ArrayList<T>();
        directoryStructureList = new ArrayList<DirectoryStructureList>();
    }

    public ArrayList<T> getDirectoryList() {
        return directoryList;
    }

    public ArrayList<DirectoryStructureList> getDirectoryStructureList() {
        return directoryStructureList;
    }

    public void addToDirectoryStructureList(DirectoryStructureList d) {
        directoryStructureList.add(d);
    }

    public void addToDirectoryList(T obj) {
        directoryList.add(obj);
    }

    public DirectoryStructureList getDSL(int i) {
        return directoryStructureList.get(i);
    }

    public T getDL(int i) {
        return directoryList.get(i);
    }

}