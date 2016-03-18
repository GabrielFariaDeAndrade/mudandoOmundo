package projeto.testes;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.Test;

import projeto.model.Conexao;
import projeto.model.CursoDAO;
import projeto.model.CursoTO;

public class CursoDAOTest {

	private Connection conexao;
	private CursoTO curso;

	@After
	public void tearDown() throws Exception {
		this.conexao = new Conexao().getConnection();
		curso = new CursoTO();
		
		curso.setCodigoCurso(100);
		curso.setNomeCurso("Sistemas de Informação");
		curso.setHorarioPrevisto("19:00");
		curso.setDataInicio(new Date(61353601200000L));
		curso.setDataTermino(new Date(61472829600000L));
		curso.setNumeroVagas(40);
		curso.setValorCurso(1200);
			
	}

	@Test
	public void test() {
		CursoDAO dao = new CursoDAO();
		
		assertEquals("Teste", dao.incluir(curso), true);
	}

}
