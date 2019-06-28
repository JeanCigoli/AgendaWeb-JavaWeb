package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;
import br.senai.sp.model.Usuario;


@WebServlet("/CadastroCompromissoServlet")
public class CadastroCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastroCompromissoServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		Compromisso comp = new Compromisso();
		comp.setDescricao(request.getParameter("txt_descricao"));
		comp.setLocal(request.getParameter("txt_local"));
		comp.setData(request.getParameter("txt_data"));
		comp.setHorario(request.getParameter("txt_horario"));
		comp.setObservacao(request.getParameter("txt_observacao"));
		comp.setConcluida(request.getParameter("concluido") != null ? true : false);
		comp.setUsuario(usuario);
		
		CompromissoDAO dao = new CompromissoDAO(comp);
		
		if(dao.cadastrar()) {
			response.sendRedirect("compromisso.jsp");
		}else {
			response.sendRedirect("cadastro_compromisso.jsp");
		}
	}

}
