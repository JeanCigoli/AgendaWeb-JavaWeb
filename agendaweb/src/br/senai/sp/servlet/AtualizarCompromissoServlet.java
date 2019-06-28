package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;



@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AtualizarCompromissoServlet() {
        super();
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Compromisso comp = new Compromisso();
		comp.setId(Integer.parseInt(request.getParameter("txt_id")));
		comp.setDescricao(request.getParameter("txt_descricao"));
		comp.setLocal(request.getParameter("txt_local"));
		comp.setData(request.getParameter("txt_data"));
		comp.setHorario(request.getParameter("txt_horario"));
		comp.setObservacao(request.getParameter("txt_observacao"));
		comp.setConcluida(request.getParameter("concluido") != null ? true : false);
		
		CompromissoDAO dao = new CompromissoDAO(comp);
		
		if(dao.atualizar()) {
			response.sendRedirect("compromisso.jsp");
		}else {
			response.sendRedirect("cadastro_compromisso.jsp");
		}
		
		
	}

}
