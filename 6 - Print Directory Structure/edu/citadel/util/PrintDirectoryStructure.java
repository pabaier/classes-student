package edu.citadel.util;


import java.io.*;
import java.util.Comparator;
import java.util.Arrays;


/**
 * Utility class that prints the directory structure to standard output
 * showing the composition of nested files and subdirectories.
 */
public class PrintDirectoryStructure
  {
    private static String fileChar = "- ";
    private static String folderChar = "+ ";
    /**
     * Prints the structure for the file whose path name is given in arg[0].
     */
    public static void main(String[] args)
      {
        if (args.length != 1)
          {
            printUsage();
            System.exit(-1);
          }

        String pathName = args[0];
        File file = new File(pathName);

        if (file.exists())
            printTree(file);
        else
            System.out.println("*** File " + pathName + " does not exist. ***");
      }


    public static void printTree(File file)
      {
        if(file.isFile())
          System.out.println(fileChar + file.getName());
        else
          printDirectory(file, 0);
      }


    private static void printDirectory(File dir, int nestingLevel)
      {
        System.out.println(getIndentString(nestingLevel) + folderChar + dir.getName());
        File[] directoryList = dir.listFiles();
        Arrays.sort(directoryList, new FolderCompare());
        for(File f : directoryList) {
          if(f.isDirectory())
            printDirectory(f, nestingLevel + 1);
          else
            printFile(f, nestingLevel + 1);
        }
      }


    private static void printFile(File file, int nestingLevel)
      {
        System.out.println(getIndentString(nestingLevel) + fileChar + file.getName());
      }


    private static String getIndentString(int nestingLevel)
      {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < nestingLevel; i++)
            s.append("   ");

        return s.toString();
      }


    private static void printUsage()
      {
        System.out.println("Usage: java edu.citadel.util.PrintDirectoryStructure(<path>)");
        System.out.println("       where <path> is the path of a file or directory");
        System.out.println();
      }

    private static class FolderCompare implements Comparator<File>{
      
      // @Override
      public int compare(File f1, File f2) {
        // File f1 = (File)o1;
        // File f2 = (File)o2;

        if(f1.isFile() && f2.isDirectory())
          return 1;
        else if(f1.isDirectory() && f2.isFile())
          return -1;
        else
          return f1.getName().compareTo(f2.getName());
      }


    }
  }
