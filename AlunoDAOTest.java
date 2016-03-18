package projeto.testes;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.After;
import org.junit.Test;

import projeto.model.AlunoDAO;
import projeto.model.AlunoTO;
import projeto.model.Conexao;

public class AlunoDAOTest {
	
	private Connection conexao;
	private AlunoTO aluno;
	
	@After
	public void tearDown() throws Exception {
		this.conexao = new Conexao().getConnection();
		aluno = new AlunoTO();
		
		aluno.setCodigoAluno(100);
		aluno.setNome("Leonardo");
        aluno.setEndereco("Rua Tal, 100");
        aluno.setTelefone("2324879");
        aluno.setEmail("sfjsdophfo.com");
        aluno.setRg("32432434");
		aluno.setCpf("12345678900");
	}

	@Test
	public void testeIncluir() {
		AlunoDAO dao = new AlunoDAO();
		
		assertEquals("Teste", dao.incluir(aluno), true);
		
		
	}

}
