package nozama;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Controller
{
	private Gui gui;//Objetk erstellen
	
	protected DefaultListModel<Artikel> dlm1 = new DefaultListModel<Artikel>(); 
	protected DefaultListModel<Artikel> dlm2 = new DefaultListModel<Artikel>(); 
	
	ArrayList<Artikel> artikelL = new ArrayList<Artikel>();
	ArrayList<Artikel> artikelR = new ArrayList<Artikel>();
	//ArrayList<Kunde> kundenL = new ArrayList<Kunde>();
	
	public Controller()
	{
		gui = new Gui();//Verlinkt
		//update();
		
		gui.list1.setModel(dlm1);
		gui.list1.setModel(dlm2);
		
		registriereListener();
		fill();
	}
	
	private void registriereListener()
	{
		gui.setListener(new sendRechts());
		gui.setListener(new sendLinks());
		gui.setListener(new Order());
	}//Ruft Funktionen aus gui auf,  welche diese vom Controller nimmt 
	
	/*public void update()
	{
		dlm1.clear();
		for(Artikel i : artikelL)
		{
			dlm1.addElement(i);
		}
		gui.list1.setModel(dlm1);
		
		dlm2.clear();
		for(Artikel k : artikelR)
		{
			dlm2.addElement(k);
		}
		gui.list2.setModel(dlm2);
	}*/
	
	
	
	public void fill()
	{
		String pfad;
		JFileChooser chooser = new JFileChooser("C:\\Users\\Win10\\eclipse-workspace\\fpa2");
		chooser.showOpenDialog(null);
		pfad = chooser.getSelectedFile().toString();//Menü von FileChoser
		
		Scanner scan;
		try
		{
			scan = new Scanner(new FileReader(pfad));
			
			while(scan.hasNextLine())//hasNextLine erstezt anderes
			{
				String line = scan.nextLine();//Einlesen
				String[] space = line.split(";");//Spliten
				
				int id = Integer.parseInt(space[0].trim());
				String name = space[1].trim();
				int preis = Integer.parseInt(space[2].trim());
				
				Artikel a = new Artikel(id, name, preis);
				dlm1.addElement(a);
			}
			
			scan.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Datei konnte nicht geöffnet werden.");
		}
		catch (InputMismatchException e) 
		{
		    System.out.println("Invalid input format in the file.");
		}
	}
	
	
	class sendRechts implements ActionListener//Button Rechts
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Gekauft");
			
			Artikel a = (Artikel) gui.list1.getSelectedValue();
			dlm2.addElement(a);
		}
	}
	
	class sendLinks implements ActionListener//Button Links
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Entfernt");
			Artikel a = (Artikel) gui.list2.getSelectedValue();
			dlm2.removeElement(a);
		}
	}
	
	class Order implements ActionListener//Button unten
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Bestellt");
			dlm2.clear();
		}
	}
}
