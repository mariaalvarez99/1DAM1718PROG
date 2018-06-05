import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame implements ActionListener{

	private String[] elementos = {"Abarth","Alfa Romeo","Aston Martin","Audi","Bentley",
			"BMW","Cadillac","Caterham","Chevrolet","Citroen","Dacia","Ferrari",
			"Fiat","Ford","Honda","Infiniti","Isuzu","Iveco","Jaguar","Jeep",
			"Kia","KTM","Lada","Lamborghini","Lancia","Land Rover","Lexus",
			"Lotus","Maserati","Mazda","Mercedes-Benz","Mini","Mitsubishi",
			"Morgan","Nissan","Opel","Peugeot","Piaggio","Porsche","Renault",
			"Rolls-Royce","Seat","Skoda","Smart","SsangYong","Subaru","Suzuki",
			"Tata","Tesla","Toyota","Volkswagen","Volvo"};
	
	private JTextField modelot = new JTextField("");
	private JComboBox<String> marcac = new JComboBox<String>(elementos);
	private JComboBox<String> motorc = new JComboBox<String>();
	private JTextField potenciat = new JTextField();
	
	private DefaultTableModel modelotabla = new DefaultTableModel();
	private JTable tabla = new JTable (modelotabla);
	
	public Frame() {
		super("Lista de Vehiculos con JTable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.setPreferredSize(new Dimension(500, 200));
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JLabel marca = new JLabel("Marca:");
		p.add(marca);
		
		p.add(marcac);
		JLabel modelo = new JLabel("Modelo:");
		p.add(modelo);
		
		p.add(modelot);
		JLabel motor = new JLabel("Motor:");
		p.add(motor);
		
		motorc.addItem("Gasolina");
		motorc.addItem("Diesel");
		motorc.addItem("Electrico");
		motorc.addItem("Hibrido");
		p.add(motorc);
		JLabel potencia = new JLabel("Potencia:");
		p.add(potencia);
		
		p.add(potenciat);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		JButton agregar = new JButton("Agregar");
		agregar.addActionListener(this);
		agregar.setActionCommand("agregar");
		p.add(agregar);
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		eliminar.setActionCommand("eliminar");
		p.add(eliminar);
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(this);
		limpiar.setActionCommand("limpiar");
		p.add(limpiar);
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		p.add(guardar);
		
		JPanel p3 = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		String[] cabecera = {"Marca","Modelo","Motor","Potencia"};
		String[] data = {"Renault","Scenic","Diesel","130"};
		
		modelotabla.addColumn("Marca");
		modelotabla.addColumn("Modelo");
		modelotabla.addColumn("Motor");
		modelotabla.addColumn("Potencia");
		modelotabla.addRow(cabecera);
		modelotabla.addRow(data);
		
		p.add(tabla);
		
		c.add(p, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		pack();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("agregar")) {
			try {
				String marcad = (String) marcac.getSelectedItem();
				String modelod = modelot.getText();
				String motord = (String) motorc.getSelectedItem();
				String potenciad = potenciat.getText();
			
				String [] fila = {marcad,modelod,motord,potenciad};
				modelotabla.addRow(fila);
				tabla.setModel(modelotabla);
			}catch (Exception a) {
		          System.out.println("Faltan datos de alguna columna");
			}	
		
		}else if (actionCommand.equals("eliminar")) {
			try {
				DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
				dtm.removeRow(tabla.getSelectedRow()); 
			 }catch (Exception a) {
		          System.out.println("No se ha selecionado ninguna fila");
			 }
			
		}else if (actionCommand.equals("limpiar")) {
			DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
	            for (int i=1; tabla.getRowCount()>i; i++) {
	                modelo.removeRow(i);
	            }
		
		}else if (actionCommand.equals("guardar")) {
			try {
		        String vehiculo = "src/vehiculos.txt";
		        BufferedWriter bfw = new BufferedWriter(new FileWriter(vehiculo ));
			        for (int i = 0 ; i < tabla.getRowCount(); i++) {
			              for(int j = 0 ; j < tabla.getColumnCount();j++) {
			                   bfw.write((String)(tabla.getValueAt(i,j)));
			               }
			               bfw.newLine();
			         }
			         bfw.close(); 
			    }catch (IOException a) {
			          System.out.println("No se pudo guardar el archivo");
		      }
		}
	}
	

}


