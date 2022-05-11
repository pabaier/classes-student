package edu.citadel.csci603.util;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import static java.nio.file.FileVisitResult.*;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Utility class for computing the number of bytes in a directory tree.
 */
public class PrintDirectoryStructure extends SimpleFileVisitor<Path>
  {
    private static boolean showHidden = false;
    private static boolean sortAlphaAsc = false;
    private static boolean sortAlphaDes = false;
    private static boolean sorting = false;
    private static int indentLevel = 0;
    private static String dirSign = "+ ";
    private static String fileSign = "- ";
    private static CompositeFolder fileSystem = new CompositeFolder("root");
    private static CompositeFolder currentFolder = fileSystem;

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
        try {
            // Arrays.asList(yourArray).contains(yourValue)
            if (args.length > 1) {
                if (args[1].equals("-h"))
                    showHidden = true;
                else if (args[1].equals("-d"))
                    dirSign = args[2] + " ";
                else if (args[1].equals("-f"))
                    fileSign = args[2] + " ";
                else if (args[1].equals("-fd")) {
                    fileSign = args[2] + " ";
                    dirSign = args[3] + " ";
                }
                else if (args[1].equals("-df")) {
                    fileSign = args[3] + " ";
                    dirSign = args[2] + " ";
                }
                else if (args[1].equals("-saa")) {
                    sortAlphaAsc = true;
                    sorting = true;
                }
                else if (args[1].equals("-sad")) {
                    sorting = true;
                    sortAlphaDes = true;
                }
                else {
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

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        if(sorting) {
            if(sortAlphaAsc) {
                Collections.sort(currentFolder.getList(), CompositeFileSystem.getSortAlphaAscending());
            }
            else if(sortAlphaDes) {
                Collections.sort(currentFolder.getList(), CompositeFileSystem.getSortAlphaDescending());
            }
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
        System.out.println("       -saa : sort in alphabetical ascending order");
        System.out.println("       -sad : sort in alphabetical descending order");
        System.out.println("       -fd | -df <char> <char> : set the file and directory prefix (in order fd or df)");
        System.out.println();
    }

    private static void printDir(CompositeFileSystem root) {
        for(CompositeFileSystem c : root.getList()) {
            System.out.println(c);
            if(c.isFolder())
                printDir(c);
        }
    }

  }
