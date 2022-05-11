package edu.citadel.csci603.util;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import static java.nio.file.FileVisitResult.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 * Utility class for computing the number of bytes in a directory tree.
 */
public class PrintDirectoryStructure extends SimpleFileVisitor<Path>
  {
    private static boolean showHidden = false;
    private static boolean sorting = false;
    private static int indentLevel = 0;
    private static String dirSign = "+ ";
    private static String fileSign = "- ";
    private static CompositeFolder fileSystem = new CompositeFolder("root");
    private static CompositeFolder currentFolder = fileSystem;
    private static Comparator strategy;

    /**
    * Prints the structure for the file whose path name is given in arg[0].
    */
    public static void main(String[] args) throws IOException
    {
        if (args.length < 1)
        {
            printUsage();
            System.exit(-1);
        }

        // different options for the command line
        try {
            boolean tripped = false;
            if (args.length > 1) {
                if (args[1].contains("--h") | args[1].contains("-help")) {
                    printUsage();
                    System.exit(0);
                }
                if (args[1].contains("h")) {
                    showHidden = true;
                    tripped = true;
                }
                if (args[1].contains("p")) {
                    fileSign = args[2] + " ";
                    dirSign = args[3] + " ";
                    tripped = true;
                }
                else {
                    if(args[1].contains("d")) {
                        dirSign = args[2] + " ";
                        tripped = true;
                    }
                    if(args[1].contains("f")) {
                        fileSign = args[2] + " ";
                        tripped = true;
                    }
                }
                if(args[1].contains("a")) {
                    strategy = CompositeFileSystem.getSortAlphaAscending();
                    // sortAlphaAsc = true;
                    sorting = true;
                    tripped = true;
                }
                else if (args[1].contains("c")) {
                    strategy = CompositeFileSystem.getSortAlphaDescending();
                    sorting = true;
                    // sortAlphaDes = true;
                    tripped = true;
                }
                
                if(!tripped) {
                    printUsage();
                    System.exit(-1);
                }
            }
        }
        catch (Exception e) {
            printUsage();
            System.exit(-1);
        }

        String pathName = args[0];
        Path startingDir = Paths.get(pathName);

        PrintDirectoryStructure pds = new PrintDirectoryStructure();
        Files.walkFileTree(startingDir, pds);

        if(sorting) {
            printDir(fileSystem);
        }
    }

    /**
    * if the file is hidden (starts with "."), it is skipped
    * if sorting is enabled the file is added to the current directory
    */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfAttrs)
    {
        if(!showHidden && file.getFileName().toString().startsWith(".")) {
        }
        else if(sorting) {
            currentFolder.add(new CompositeFile(getIndent() + fileSign + file.getFileName()));
        }
        else {
            System.out.println(getIndent() + fileSign + file.getFileName());
        }
        return CONTINUE;
    }

    /*
    * if the directory is hidden (starts with "."), it (and all descendants) is skipped
    * if sorting is enable, a new folder is made, stored in the current folder, then set to
    * the current folder.
    */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes bfAttrs)
    {
        if(!showHidden && dir.getFileName().toString().startsWith("."))
            return SKIP_SUBTREE;
        if(sorting) {
            CompositeFolder newFolder = new CompositeFolder(getIndent() + dirSign + dir.getFileName());
            currentFolder.add(newFolder);
            currentFolder = newFolder;
        }
        else {
            System.out.println(getIndent() + dirSign + dir.getFileName());
        }
        indentLevel ++;
        return CONTINUE;
    }

    /*
    * if sorting is enabled, each directory gets sorted according to the
    * sorting strategy after it is visited. 
    */
    @Override
    @SuppressWarnings("unchecked")             
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        if(sorting) {
            Collections.sort(currentFolder.getList(), strategy);
            currentFolder = currentFolder.getParent();
        }
        indentLevel --;
        return CONTINUE;
    }


    // Use inherited implementation for method visitFileFailed()

    private static String getIndent() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < indentLevel; i++)
            s.append("   ");
        return s.toString();
    }

    private static void printUsage()
    {
        System.out.println("Usage: java edu.citadel.csci603.util.PrintDirectoryStructure <path>");
        System.out.println("       where <path> is the path of a file or directory");
        System.out.println("Flags: -h : show hidden files and folders (default does not list hidden files and folders)");
        System.out.println("       -f <char> : set the file prefix to <char>");
        System.out.println("       -d <char> : set the directory prefix to <char>");
        System.out.println("       -p <char> <char> : set the directory and file prefix (in that order, with a space)");
        System.out.println("       -a : sort in alphabetical ascending order");
        System.out.println("       -c : sort in alphabetical descending order");
        System.out.println("       --h | -help : prompt for help");
        System.out.println("Example to show hidden files:");
        System.out.println("\tjava edu.citadel.csci603.util.PrintDirectoryStructure D:\\ -h");
        System.out.println("Example to set file prefix to '%' and sort ascending:");
        System.out.println("\tjava edu.citadel.csci603.util.PrintDirectoryStructure D:\\ -af %");
        System.out.println();
    }

    // recursively print the filesystem if sorted
    private static void printDir(CompositeFileSystem root) {
        for(CompositeFileSystem c : root.getList()) {
            System.out.println(c);
            if(c.isFolder())
                printDir(c);
        }
    }

  }
