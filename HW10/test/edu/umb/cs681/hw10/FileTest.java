package edu.umb.cs681.hw10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private FileSystem fileSystem;
    @BeforeEach
    public void setup(){
        fileSystem = TestFixtureInitializer.createFS();
    }


    private String[] file_to_string(File f){
        Optional<Directory> optional_directory = Optional.ofNullable(f.getParent());
        String[] file = {f.getName(),
                Integer.toString(f.getSize()),
                optional_directory.isPresent()?f.getParent().getName():"null"};
        return file;
    }

    @Test
    public void Test1(){
        String[] expected = {"y", "7", "Lib"};
        Directory root = fileSystem.get_root_directories().get(0);
        Directory bin = (Directory) root.getChildren().get(1);
        File y = (File) bin.get_files().get(0);
        assertArrayEquals(expected, file_to_string(y));
    }

    @Test
    public void Test2(){
        String[] expected = {"x", "7", "Apps"};
        Directory root = fileSystem.get_root_directories().get(0);
        Directory Apps = (Directory) root.getChildren().get(0);
        File x = Apps.get_files().get(0);
        assertArrayEquals(expected, file_to_string(x));
    }



}