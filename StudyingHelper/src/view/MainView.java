package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class MainView extends JFrame{
	
	JList containList;
	JList chapterList;
	
	MainView(){
		super("Studying Helper");
		this.setIconImage(new ImageIcon("c:/Workspace/StudyingHelper/resources/icono.png").getImage());
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(NavigationPanel(), BorderLayout.WEST);
		
		this.add(mainPanel);
		
		
		pack();
	}
	
	
	public JPanel NavigationPanel() {
		JPanel mainPanel = new JPanel();
		JPanel chapterPanel = new JPanel(new BorderLayout());
		JLabel chapter = new JLabel("Capitulos:");
		chapterPanel.add(chapter, BorderLayout.NORTH);
		chapterList = new JList<String>();
		chapterPanel.add(chapterList, BorderLayout.CENTER);
		mainPanel.add(chapterPanel);
		JPanel containPanel = new JPanel(new BorderLayout());
		JLabel contain = new JLabel("Contenido:");
		containPanel.add(contain, BorderLayout.NORTH);
		containList = new JList<String>();
		containPanel.add(containList, BorderLayout.CENTER);
		mainPanel.add(containPanel);
		
		return mainPanel;
	}
	
	public void run() {
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MainView().run();
	}
}
