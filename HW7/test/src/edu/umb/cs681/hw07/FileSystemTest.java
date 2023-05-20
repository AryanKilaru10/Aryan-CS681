package edu.umb.cs681.hw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @Test
    public void FileSystem(){
        FileSystem FS1 = FileSystem.get_File_Instance();
        FileSystem FS2 = FileSystem.get_File_Instance();
        assertSame(FS1, FS2);
    }

}