import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.argentum.modelo.Negociacao;

@WebServlet("/principal")
public class Principal extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter escritor = resp.getWriter();
		
		
		escritor.write("<html>");
		escritor.write("<body>");
		escritor.write("foi") ;
		escritor.write("</body>");
		escritor.write("</html>");
		Negociacao negociacao = new Negociacao(10, 1, LocalDateTime.now());
		System.out.println(negociacao.getClass().getClassLoader());
		negociacao.imprirTextoNoConsole();
		escritor.flush();
	}
	
}
