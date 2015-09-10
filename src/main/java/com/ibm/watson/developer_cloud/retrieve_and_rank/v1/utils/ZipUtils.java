package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ZipUtils {
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private ZipUtils() {
    }

    public static File buildConfigZip(final String configName, final Path parentDir) {
        final File zipFile = createEmptyZipFile(configName);

        try (final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile))) {
            Files.walkFileTree(parentDir, new FileVisitor<Path>() {
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    writeZipEntry(out, parentDir.relativize(path).toString(),
                            FileUtils.readFileToByteArray(path.toFile()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    throw new IllegalStateException(
                            MSGS.format(FAILED_TO_VISIT_1, file.toAbsolutePath().getFileName()));
                }
            });

            return zipFile;
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_ZIPPING_1, parentDir.toString()), e);
        }
    }

    private static File createEmptyZipFile(String configName) {
        try {
            return File.createTempFile(configName, ".zip");
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_CREATING_ZIP_1, configName + ".zip"), e);
        }
    }

    private static void writeZipEntry(ZipOutputStream out, String name, byte[] data) throws IOException {
        final ZipEntry entry = new ZipEntry(StringUtils.removeStart(name, "/"));
        out.putNextEntry(entry);
        out.write(data, 0, data.length);
        out.closeEntry();
    }

}
