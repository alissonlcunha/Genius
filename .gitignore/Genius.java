import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Genius extends JFrame {

	// private JButton buttons[] = new JButton[4];// Define um array para
	// referenciar 4
	static List<Integer> vetorComputador = new ArrayList<>();
	static List<Integer> vetorJogador = new ArrayList<>(); // botões
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuSair;
	private JMenuItem menuIniciar;
	private JButton botaoVerde;
	private JButton botaoAzul;
	private JButton botaoVermelho;
	private JButton botaoAmarelo;

	/* Construtor Genius */
	public Genius() {
		initComponents();
		setSize(300, 300);// Seta o tamanho do formulário
	}

	/* Inicializa o formulário e todos os seus componentes */
	private void initComponents() {
		/*
		 * for (int i = 0; i < 4; i++) { buttons[i] = new JButton("");// Cria os
		 * botões e coloca a referência // no array
		 * getContentPane().add(buttons[i]);// Adiciona os botões ao formulário
		 * buttons[i].setBackground(Color.WHITE); }
		 */
		boolean erro = false;
		Random gerador = new Random();
		// int random_botao = gerador.nextInt(4);
		vetorComputador.add(gerador.nextInt(4));
		botaoVerde = new JButton("");
		getContentPane().add(botaoVerde);
		botaoVerde.setBackground(Color.GREEN.darker());
		botaoAmarelo = new JButton("");
		getContentPane().add(botaoAmarelo);
		botaoAmarelo.setBackground(Color.YELLOW.darker());
		botaoVermelho = new JButton("");
		getContentPane().add(botaoVermelho);
		botaoVermelho.setBackground(Color.RED.darker());
		botaoAzul = new JButton("");
		getContentPane().add(botaoAzul);
		botaoAzul.setBackground(Color.BLUE.darker());

		menuBar = new JMenuBar();
		menu = new JMenu();
		menuSair = new JMenuItem();
		menuIniciar = new JMenuItem();

		getContentPane().setLayout(new java.awt.GridLayout(2, 2));// Layout para
																	// os botoes
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		/* Define um evento de pressionamento dos botoes */
		botaoVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piscaBotao(botaoVerde);
			}
		});
		botaoAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piscaBotao(botaoAzul);
			}
		});
		botaoVermelho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piscaBotao(botaoVermelho);
			}
		});
		botaoAmarelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piscaBotao(botaoAmarelo);
			}
		});
		menu.setText("Jogo");
		menuSair.setText("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		menuIniciar.setText("Iniciar");
		menuIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/* Efetua um teste em todos os botoes */
				// for (int i = 0; i < 4; i++) {
				// piscaBotao(i);
				// }
				while (!erro) {
					verificaBotao();
				}
			}
		});

		menu.add(menuIniciar);
		menu.add(menuSair);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	private void verificaBotao(){
		for (int i = 0; i < vetorComputador.size(); i++) {
			Random gerador = new Random();
			int random_botao = gerador.nextInt(4);
			System.out.println(random_botao);
			if (random_botao == 0) {
				JButton b = botaoVerde;
				piscaBotao(b);
			}
			if (random_botao == 1) {
				JButton b = botaoAmarelo;
				piscaBotao(b);
			}
			if (random_botao == 2) {
				JButton b = botaoVermelho;
				piscaBotao(b);
			}
			if (random_botao == 3) {
				JButton b = botaoAzul;
				piscaBotao(b);
			}
		}
		
	}

	private void piscaBotao(JButton b) {
		if (b == botaoVerde) {
			b.setBackground(Color.GREEN.brighter());
			try {
				update(getGraphics());// Atualiza o formulário
				Thread.sleep(1200);// INterrompe a rotina
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			b.setBackground(Color.GREEN.darker());
		}
		if (b == botaoAmarelo) {
			b.setBackground(Color.YELLOW.brighter());
			try {
				update(getGraphics());// Atualiza o formulário
				Thread.sleep(1200);// INterrompe a rotina
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			b.setBackground(Color.YELLOW.darker());
		}
		if (b == botaoVermelho) {
			b.setBackground(Color.RED.brighter());
			try {
				update(getGraphics());// Atualiza o formulário
				Thread.sleep(1200);// INterrompe a rotina
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			b.setBackground(Color.RED.darker());
		}
		if (b == botaoAzul) {
			b.setBackground(new Color(0,94,255));
			try {
				update(getGraphics());// Atualiza o formulário
				Thread.sleep(1200);// INterrompe a rotina e
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			b.setBackground(Color.BLUE.darker());
		}

	}

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);// Frescura :)
		new Genius().setVisible(true);// Cria o objeto Genius e o torna visível
	}
}
