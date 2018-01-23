package com.springmybatis.noweb;

import java.io.File;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

class Tar {
    @Option(names = "-c", description = "create a new archive")
    boolean create;

    @Option(names = { "-f", "--file" }, paramLabel = "ARCHIVE", description = "the archive file")
    File archive;

    @Parameters(paramLabel = "FILE", description = "one ore more files to archive")
    File[] files;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;
}