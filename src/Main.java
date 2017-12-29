import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main extends JFrame implements ActionListener{

	JComponent component;
	JPanel homePanel;
	JPanel textAreaPanel;
	JTextArea textArea;




	JMenuBar menuBar;
	JMenu fileMenu, aboutMenu;
	JMenuItem aboutMenuItem, clearContentMenuItem, saveAsMenuItem;

	public void saveAs()
	{
		final JFileChooser SaveAs = new JFileChooser();
		SaveAs.setApproveButtonText("Save");
		int actionDialog = SaveAs.showOpenDialog(this);
		if (actionDialog != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));

			textArea.write(outFile);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (outFile != null) {
				try {
					outFile.close();
				} catch (IOException e) {

				}
			}
		}


	}

	public void setListener()
	{
		aboutMenuItem.addActionListener(this);
		clearContentMenuItem.addActionListener(this);
		saveAsMenuItem.addActionListener(this);
	}

	public void setMenu()
	{
		menuBar.add(fileMenu);

		menuBar.add(aboutMenu);
		fileMenu.add(clearContentMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(saveAsMenuItem);
		aboutMenu.add(aboutMenuItem);



	}


	public void initComponents()
	{
		homePanel = new JPanel();
		textAreaPanel = new JPanel();
		menuBar = new JMenuBar();
		fileMenu = new JMenu("file");
		aboutMenu = new JMenu("about");
		clearContentMenuItem = new JMenuItem("clear content");
		saveAsMenuItem = new JMenuItem("save as");
		aboutMenuItem = new JMenuItem("about me");
		textArea = new JTextArea();

	}

	public void setComponents()
	{
		homePanel.setLayout(new BorderLayout());
		homePanel.add(menuBar,BorderLayout.NORTH);

		homePanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

		setMenu();
		setListener();
	}
	public void viewComponents()
	{
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("notepad");
		add(homePanel);
		setVisible(true);

	}

	public Main() {
		// TODO Auto-generated constructor stub
		initComponents();
		setComponents();
		viewComponents();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aboutMenuItem)
		{
			JOptionPane.showMessageDialog(null,"1901475255 - Titus Efferian - LA01", "message",JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource()==clearContentMenuItem)
		{
			textArea.setText(null);
		}
		if(e.getSource()==saveAsMenuItem)
		{
			saveAs();
		}
	}
}
