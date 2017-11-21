package edu.citadel.csci603.util;


import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import static java.nio.file.FileVisitResult.*;


/**
 * Utility class for computing the number of bytes in a directory tree.
 */
public class ComputeDiskSpaceVisitor extends SimpleFileVisitor<Path>
  {
    private long diskSpace = 0;


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

        ComputeDiskSpaceVisitor cdsv = new ComputeDiskSpaceVisitor();
        Files.walkFileTree(startingDir, cdsv);

        System.out.println(pathName + ": " + cdsv.getDiskSpace() + " bytes");
      }


    public long getDiskSpace()
      {
        return diskSpace;
      }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfAttrs)
      {
        System.out.println("File " + file.getFileName() + " has size " + bfAttrs.size());
        diskSpace = diskSpace + bfAttrs.size();
        return CONTINUE;
      }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes bfAttrs)
      {
        System.out.println("Directory " + dir.getFileName() + " has size " + bfAttrs.size());
        diskSpace = diskSpace + bfAttrs.size();
        return CONTINUE;
      }


    // Use inherited implementation for method visitFileFailed()


    private static void printUsage()
      {
        System.out.println("Usage: java edu.citadel.csci603.util.ComputeDiskSpaceVisitor(<path>)");
        System.out.println("       where <path> is the path of a file or directory");
        System.out.println();
      }
  }
