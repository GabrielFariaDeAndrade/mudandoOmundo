package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

	private Connection conexao;

	public AlunoDAO() {
		this.conexao = new Conexao().getConnection();
	}

	public boolean incluir(AlunoTO aluno) {
		boolean ok = false;
		String sql = "insert into aluno " + "(idAluno, nome, endereco, telefone, email, rg, cpf)"
				+ " values (?,?,?,?,?,?,?)";
		
		try {
	        // prepared statement para inserção
	        PreparedStatement stmt = conexao.prepareStatement(sql);

	        // seta os valores
	        

	        stmt.setLong(1, aluno.getCodigoAluno());
	        stmt.setString(2, aluno.getNome());
	        stmt.setString(3, aluno.getEndereco());
	        stmt.setString(4, aluno.getTelefone());
	        stmt.setString(5, aluno.getEmail());
	        stmt.setString(6, aluno.getRg());
	        stmt.setString(7, aluno.getCpf());

	        // executa
	        stmt.executeUpdate();	        
	        stmt.close();
	        
	        ok = true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ok;
	}
	
	public boolean alterar(AlunoTO aluno) {
		boolean ok = false;
		String sql = "Update aluno Set nome = ?, endereco = ?, telefone = ?, email = ?, rg = ?, cpf = ? where idAluno = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEndereco());
			stmt.setString(3, aluno.getTelefone());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getRg());
			stmt.setString(6, aluno.getCpf());
			stmt.setLong(7, aluno.getCodigoAluno());
			
			stmt.executeUpdate();
			stmt.close();
			
			ok = true;
		} catch(SQLException excecao) {
			excecao.printStackTrace();
		}
		return ok;
	}
	
	public AlunoTO consultar(long raAluno) {
		String sql = "Select * From aluno Where idAluno = ?";
        AlunoTO aluno = null;
        
        try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
				
	        stmt.setLong(1, raAluno);
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	if(rs.getLong("idAluno") == raAluno) {
	        		aluno = new AlunoTO();
	        		aluno.setCodigoAluno(rs.getLong("idAluno"));
	        		aluno.setNome(rs.getString("nome"));
	        		aluno.setEndereco(rs.getString("endereco"));
	        		aluno.setTelefone(rs.getString("telefone"));
	        		aluno.setEmail(rs.getString("email"));
	        		aluno.setRg(rs.getString("rg"));
	        		aluno.setCpf(rs.getString("cpf"));
	        	}
	        }
	        
	        rs.close();
	        stmt.close();
	        
        } catch(SQLException excecao) {
        	excecao.printStackTrace();
        }
        
        return aluno;
	}

	public boolean excluir(long raAluno) {
		boolean ok = false;
		String sql = "Delete From aluno Where idAluno = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setLong(1, raAluno);
			
			stmt.executeUpdate();
			stmt.close();
			
			ok = true;
		} catch(SQLException excecao) {
			excecao.printStackTrace();
		}
		
		return ok;
	}
	
}// fim da classe