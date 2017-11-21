package edu.citadel.csci603.util;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import static java.nio.file.FileVisitResult.*;


/**
 * Utility class for computing the number of bytes in a directory tree.
 */
public class PrintDirectoryStructure extends SimpleFileVisitor<Path>
  {

    private static int indentLevel = 0;
    private static final String dirSign = "+ ";
    private static final String fileSign = "- ";

    /**
    * Prints the structure for the file whose path name is given in arg[0].
    */
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            printUsage();
            System.exit(-1);
        }

        String pathName = args[0];
        Path startingDir = Paths.get(pathName);

        PrintDirectoryStructure pds = new PrintDirectoryStructure();
        Files.walkFileTree(startingDir, pds);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfAttrs)
    {
        System.out.println(getIndent() + fileSign + file.getFileName());

        return CONTINUE;
    }


    // @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes bfAttrs)
    {
        System.out.println(getIndent() + dirSign + dir.getFileName());
        indentLevel ++;
        return CONTINUE;
        
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
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
        System.out.println("Usage: java edu.citadel.csci603.util.ComputeDiskSpaceVisitor(<path>)");
        System.out.println("       where <path> is the path of a file or directory");
        System.out.println();
    }
  }
