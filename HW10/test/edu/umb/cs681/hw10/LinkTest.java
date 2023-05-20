package edu.umb.cs681.hw10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private FileSystem fileSystem;
    @BeforeEach
    public void setup(){
        fileSystem = TestFixtureInitializer.createFS();
    }

    @Test
    public void Test1(){
        Directory root  = TestFixtureInitializer.createFS().get_root_directories().get(0);
        Directory home = (Directory)root.getChildren().get(2);
        Directory pictures = (Directory) home.getChildren().get(0);
        Link d = (Link) root.getChildren().get(3);
        assertSame(pictures, d.getTarget());
    }

    @Test
    public void Test2(){
        Directory root = fileSystem.get_root_directories().get(0);
        Directory Apps = (Directory) root.getChildren().get(0);
        File x = Apps.get_files().get(0);
        Link e = (Link) root.getChildren().get(4);
        assertSame(x, e.getTarget());
    }


}