package fr.iutvalence.java.project.gui;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class SaveGame
{

      public static void main(String[] args)
      {

            String chaine = "";
            String fileName = "fichiertexte.txt";
            FileOutputStream saver;

            final File file = new File(fileName);

            BufferedWriter out = null;
            try
            {
                  saver = new FileOutputStream(new File("test2.txt"));
                  out = new BufferedWriter(new FileWriter(file));
            }
            catch (final IOException e)
            {
            }

      }
}
