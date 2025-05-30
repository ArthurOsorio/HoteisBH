package hoteisBH;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

public class OverviewQuartos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}

	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}

	public JLabel getLblDataRes() {
		return lblDataRes;
	}

	public void setLblDataRes(JLabel lblDataRes) {
		this.lblDataRes = lblDataRes;
	}

	public JLabel getLblDataSaida() {
		return lblDataSaida;
	}

	public void setLblDataSaida(JLabel lblDataSaida) {
		this.lblDataSaida = lblDataSaida;
	}

	public JLabel getLblReservado() {
		return lblReservado;
	}

	public void setLblReservado(JLabel lblReservado) {
		this.lblReservado = lblReservado;
	}

	private Connection con = ConexaoSQL.getConnection();
	private ResultSet rs;
	private int id;
	private JLabel lblNome = new JLabel("");
	private JLabel lblCPF = new JLabel("");
	private JLabel lblTelefone = new JLabel("");
	private JLabel lblDataRes = new JLabel("");
	private JLabel lblDataSaida = new JLabel("");
	private JLabel lblReservado = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OverviewQuartos frame = new OverviewQuartos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OverviewQuartos()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1345, 877);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		try {
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String url = "SELECT * from quartos "+"ORDER BY quarto_id";
			rs = stm.executeQuery(url);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		try {
			rs.last();
			id=rs.getInt("quarto_id")+1;
			rs.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JButton btnsquartos[] = new JButton[id];
		try {
			do{
				btnsquartos[rs.getInt("quarto_id")] = new JButton(String.format("Quartos %d", rs.getInt("quarto_id")));
				btnsquartos[rs.getInt("quarto_id")].addActionListener(new BTNQuartosListener(this,rs.getInt("quarto_id")));
				panel.add(btnsquartos[rs.getInt("quarto_id")]);
			}while(rs.next());
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNomeTitle = new JLabel("Nome");
		lblNomeTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNomeTitle, BorderLayout.NORTH);
		
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNome, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCPFTitle = new JLabel("CPF");
		lblCPFTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPFTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblCPFTitle, BorderLayout.NORTH);
		
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblCPF, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTelefoneTitle = new JLabel("Telefone");
		lblTelefoneTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefoneTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_6.add(lblTelefoneTitle, BorderLayout.NORTH);
		
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblTelefone, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDataResTitle = new JLabel("Data da Reserva");
		lblDataResTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataResTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lblDataResTitle, BorderLayout.NORTH);
		
		lblDataRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataRes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_5.add(lblDataRes, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDataSaidaTitle = new JLabel("Data Esperada de Saida");
		lblDataSaidaTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataSaidaTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_7.add(lblDataSaidaTitle, BorderLayout.NORTH);
		
		lblDataSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_7.add(lblDataSaida, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblReservadoTitle = new JLabel("Reservado");
		lblReservadoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservadoTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_8.add(lblReservadoTitle, BorderLayout.NORTH);
		
		lblReservado.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_8.add(lblReservado, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setActionCommand("RESERVAR");
		btnReservar.addActionListener(new ActionButtonsListenerOverviewQuartos(this));
		panel_2.add(btnReservar);
		
		JButton btnDesocupar = new JButton("Desocupar");
		btnDesocupar.setActionCommand("DESOCUPAR");
		btnDesocupar.addActionListener(new ActionButtonsListenerOverviewQuartos(this));
		panel_2.add(btnDesocupar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setActionCommand("SAIR");
		btnSair.addActionListener(new ActionButtonsListenerOverviewQuartos(this));
		panel_2.add(btnSair);
		
	}
}
