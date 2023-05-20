package edu.umb.cs681.hw07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private FileSystem fileSystem;
    @BeforeEach
    public void setup(){
        fileSystem = TestFixtureInitializer.createFS();
    }
    private String[] directory_to_string(Directory d){
        Optional<Directory> optional_directory = Optional.ofNullable(d.getParent());
        String[] file = {d.getName(),
                Integer.toString(d.getSize()),
                optional_directory.isPresent()?d.getParent().getName():"null"};
        return file;
    }

    @Test
    public void Test1(){
        String[] expected = {"Apps", "7", "root"};
        Directory root = fileSystem.get_root_directories().get(0);
        Directory Apps = (Directory) root.getChildren().get(0);
        assertArrayEquals(expected, directory_to_string(Apps));
    }

    @Test
    public void Test2(){
        String[] expected = {"root", "7", "null"};
        Directory root = fileSystem.get_root_directories().get(0);
        assertArrayEquals(expected, directory_to_string(root));
    }



}