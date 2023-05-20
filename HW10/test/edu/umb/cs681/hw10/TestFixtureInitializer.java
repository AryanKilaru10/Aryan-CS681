package edu.umb.cs681.hw10;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        Directory root = new Directory("root", 7, LocalDateTime.now(), null);

        Directory Apps = new Directory("Apps", 7, LocalDateTime.now(), root);

        Directory bin = new Directory("Lib", 7, LocalDateTime.now(), root);

        Directory Home = new Directory("Home", 7, LocalDateTime.now(), root);

        Directory pictures = new Directory("Code", 7, LocalDateTime.now(), Home);

        File x = new File("x", 7, LocalDateTime.now(), Apps);

        File y = new File("y", 7, LocalDateTime.now(), bin);

        File a = new File("a", 7, LocalDateTime.now(), pictures);

        File b = new File("b", 7, LocalDateTime.now(), pictures);

        File c = new File("c", 7, LocalDateTime.now(), Home);

        Link d = new Link("d",7, LocalDateTime.now(), pictures, root);

        Link e = new Link("e", 7, LocalDateTime.now(), x, root);

        FileSystem fileSystem = FileSystem.get_File_Instance();
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(Home);
        root.appendChild(pictures);
        root.appendChild(x);
        bin.appendChild(y);
        pictures.appendChild(a);
        pictures.appendChild(b);
        Home.appendChild(c);
        root.appendChild(d);
        fileSystem.add_Root(root);
        return fileSystem;




    }
}
