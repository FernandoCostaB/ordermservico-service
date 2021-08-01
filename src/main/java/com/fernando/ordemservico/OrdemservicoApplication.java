package com.fernando.ordemservico;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernando.ordemservico.domain.Exame;
import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.domain.OrdemServicoExame;
import com.fernando.ordemservico.domain.Paciente;
import com.fernando.ordemservico.domain.PostoColeta;
import com.fernando.ordemservico.repositories.ExameRepository;
import com.fernando.ordemservico.repositories.MedicoRepository;
import com.fernando.ordemservico.repositories.OrdemServicoExameRepository;
import com.fernando.ordemservico.repositories.OrdemServicoRepository;
import com.fernando.ordemservico.repositories.PacienteRepository;
import com.fernando.ordemservico.repositories.PostoColetaRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@SpringBootApplication
public class OrdemservicoApplication implements CommandLineRunner {
	
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ExameRepository exameRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PostoColetaRepository postoColetaRepository;
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	@Autowired
	private OrdemServicoExameRepository ordemServicoExameRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(OrdemservicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		
		//Criando Pacientes
		Date data = formato.parse("16/08/1994");
		Paciente pac1 = new Paciente(null,"João",data,"masculino", "Rua 45 nº8 Japiim" );
		Paciente pac2 = new Paciente(null,"Maria",data,"feminino", "Rua 45 nº8 Japiim" );
		Paciente pac3= new Paciente(null,"Pedro",data,"masculino", "Rua 45 nº8 Japiim" );
		Paciente pac4 = new Paciente(null,"Carlos",data,"masculino", "Rua 45 nº8 Japiim" );
	
		pacienteRepository.saveAll(Arrays.asList(pac1,pac2,pac3,pac4));
		
		
		//Criando Exames
		Exame ex1 = new Exame(null,"Fezes", 2.50);
		Exame ex2 = new Exame(null,"Urina", 5.00);
		Exame ex3 = new Exame(null, "Cardiograma", 100.00);
		Exame ex4 = new Exame(null, "ultrassom", 250.00);
		
		exameRepository.saveAll(Arrays.asList(ex1,ex2,ex3,ex4));
		
		//Criando Medicos
		Medico md1 = new Medico(null,"Roberto", "Cardiologista");
		Medico md2 = new Medico(null,"Carlo", "Neuro");
		Medico md3 = new Medico(null,"Thiago", "clinico geral");
		Medico md4 = new Medico(null,"Larissa", "Ginecologista");
		
		medicoRepository.saveAll(Arrays.asList(md1,md2,md3,md4));
		
		
		//Criando Posto de Coleta
		PostoColeta pc1 = new PostoColeta(null,"Unidade 1", "Rua vasco da gama nº45");
		PostoColeta pc2 = new PostoColeta(null,"Unidade 2", "Rua pedroso nº5");
		PostoColeta pc3 = new PostoColeta(null,"Unidade 3", "Rua floriano peixoto nº89");
		PostoColeta pc4 = new PostoColeta(null,"Unidade 4", "Rua eduardo ribeiro nº100");
		
		postoColetaRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4)); 
		
		//Criando Ordem de Servico
		Date data2 = formato.parse("01/08/2021");
		OrdemServico os1 = new OrdemServico(null,data2,"GEAP", pac1, pc1, md1);
		OrdemServico os2 = new OrdemServico(null,data2,"UNIMED", pac2, pc2, md2);
		OrdemServico os3 = new OrdemServico(null,data2,"BRADESCO", pac3, pc3, md3);
		
		
		pac1.getOrdensServicos().addAll(Arrays.asList(os1));
		pac2.getOrdensServicos().addAll(Arrays.asList(os2));
		pac3.getOrdensServicos().addAll(Arrays.asList(os3));
		
		ordemServicoRepository.saveAll(Arrays.asList(os1,os2,os3));
		
		//Criando Ordens de Servicos com Exames
		OrdemServicoExame osExame1 = new OrdemServicoExame(null, ex1.getPreco(), os1);
		OrdemServicoExame osExame2 = new OrdemServicoExame(null, ex2.getPreco(), os2);
		OrdemServicoExame osExame3 = new OrdemServicoExame(null, ex3.getPreco(), os3);
		
		ex1.getOrdensServicosExames().addAll(Arrays.asList(osExame1));
		ex2.getOrdensServicosExames().addAll(Arrays.asList(osExame2));
		ex3.getOrdensServicosExames().addAll(Arrays.asList(osExame3));
		
		osExame1.getExames().addAll(Arrays.asList(ex1));
		osExame2.getExames().addAll(Arrays.asList(ex2));
		osExame3.getExames().addAll(Arrays.asList(ex3));
		
		
		ordemServicoExameRepository.saveAll(Arrays.asList(osExame1, osExame2, osExame3));
	}

}
