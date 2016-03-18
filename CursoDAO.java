package projeto.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAO {

	private Connection conexao;

	public CursoDAO() {
		this.conexao = new Conexao().getConnection();
	}

	public boolean incluir(CursoTO curso) {
		boolean ok = false;
		String sql = "insert into curso " + "(idCurso, nome, dataInicio, dataTermino, horario, numeroVagas, valor)"
				+ " values (?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores

			Date dataInicioSQL = new Date(curso.getDataInicio().getTime());
			Date dataTerminoSQL = new Date(curso.getDataTermino().getTime());

			stmt.setInt(1, curso.getCodigoCurso());
			stmt.setString(2, curso.getNomeCurso());
			stmt.setDate(3, dataInicioSQL);
			stmt.setDate(4, dataTerminoSQL);
			stmt.setString(5, curso.getHorarioPrevisto());
			stmt.setInt(6, curso.getNumeroVagas());
			stmt.setDouble(7, curso.getValorCurso());

			// executa
			stmt.executeUpdate();
			stmt.close();

			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	public boolean alterar(CursoTO curso) {
		boolean ok = false;
		String sql = "Update curso Set nome = ?, dataInicio = ?, dataTermino = ?, horario = ?, numeroVagas = ?, "
				+ "valor = ? Where idCurso = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, curso.getNomeCurso());
			stmt.setDate(2, curso.getDataInicio());
			stmt.setDate(3, curso.getDataTermino());
			stmt.setString(4, curso.getHorarioPrevisto());
			stmt.setInt(5, curso.getNumeroVagas());
			stmt.setDouble(6, curso.getValorCurso());
			stmt.setInt(7, curso.getCodigoCurso());
			
			stmt.executeUpdate();
			stmt.close();
			
			ok = true;
		} catch (SQLException excecao) {
			excecao.printStackTrace();
		}
		return ok;
	}

	public CursoTO consultar(int codigo) {
		String sql = "Select * From curso Where idCurso = ?";

		CursoTO curso = null;

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				curso = new CursoTO();

				curso.setCodigoCurso(rs.getInt("idCurso"));
				curso.setNomeCurso(rs.getString("nome"));
				curso.setDataInicio(rs.getDate("dataInicio"));
				curso.setDataTermino(rs.getDate("dataTermino"));
				curso.setHorarioPrevisto(rs.getString("horario"));
				curso.setNumeroVagas(rs.getInt("numeroVagas"));
				curso.setValorCurso(rs.getDouble("valor"));
			}

			rs.close();
			stmt.close();

		} catch (SQLException excecao) {
			excecao.printStackTrace();
		}
		return curso;
	}

	 public boolean excluir(int cod) {
		 boolean ok = false;
		 String sql = "Delete From curso Where idCurso = ?";
		 
		 try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			 
			 stmt.setInt(1, cod);
			 
			 stmt.executeUpdate();
			 stmt.close();
			 
			 ok = true;
		 } catch(SQLException excecao) {
			 excecao.printStackTrace();
		 }
		 return ok;
	 }	 

}// fim da classe