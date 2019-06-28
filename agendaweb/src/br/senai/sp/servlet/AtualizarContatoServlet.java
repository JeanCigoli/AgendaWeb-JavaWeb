package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.model.Contato;
import br.senai.sp.model.Tipo;
import br.senai.sp.model.Usuario;


@WebServlet("/AtualizarContatoServlet")
public class AtualizarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AtualizarContatoServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		contato.setId(Integer.parseInt(request.getParameter("txt_id")));
		contato.setNome(request.getParameter("txt_nome"));
		contato.setDataNascimento(request.getParameter("txt_datanascimento"));
		contato.setEmail(request.getParameter("txt_email"));
		contato.setTelefone(request.getParameter("txt_telefone"));
		contato.setEndereco(request.getParameter("txt_endereco"));
		contato.setTipo(Tipo.valueOf(request.getParameter("combo_tipo")));
		
		ContatoDAO dao = new ContatoDAO(contato);
		
		if(dao.atualizar()) {
			response.sendRedirect("meus_contatos.jsp");
		} else {
			response.sendRedirect("erro.jsp");
		}
		
	}

}
