package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cidade;
import model.Estado;
import model.Pessoa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OlaIfamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter saida = resp.getWriter();

        Estado amazonas = new Estado();
        Cidade manaus = new Cidade();

        String parametroNome = req.getParameter("name");


        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();


        amazonas.setNome("Amazonas");
        amazonas.setSigla("Am");

        manaus.setNome("Manaus");
        manaus.setEstado(amazonas);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Joao");
        pessoa1.setEmail("joao@gmail.com");
        pessoa1.setFone("234234-234");
        pessoa1.setCidade(manaus);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Pedro");
        pessoa2.setEmail("Pedro@gmail.com");
        pessoa2.setFone("234234-001");
        pessoa2.setCidade(manaus);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Maria");
        pessoa3.setEmail("Maria@gmail.com");
        pessoa3.setFone("234234-002");
        pessoa3.setCidade(manaus);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);


        pessoa1.setNome("Joao");
        pessoa1.setCidade(manaus);
        pessoa1.setEmail("joao@gmail.com");
        pessoa1.setFone("234234-234");
        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("<meta charset=\"UTF-8\">");
        saida.println("</head>");
        saida.println("<body>");


        saida.println("<h1>Ola Ifam</h1>");
        saida.println("<p>-------------------------</p>");

        saida.println("<form>");
        saida.println("     <label>Nome</label>");
        saida.println("     <input type = 'text' id = 'filtroNome' name = 'nome' value=''>");
        saida.println("     <button type = 'submit' >Pesquisar</button>");

        saida.println("</form>");

        saida.println("<p></p>");

        saida.println("<table border = 1px>");


        saida.println("<tr>");
        saida.println("<th>Nome</th>");
        saida.println("<th>Fone</th>");
        saida.println("<th>Email</th>");
        saida.println("<th>Cidade</th>");
        saida.println("<th>Estado</th>");

        for(Pessoa p : pessoas) {
            if(p.getNome().contains(parametroNome)) {
                saida.println("</tr>");
                saida.println("     <tr>");
                saida.println("     <th>" + p.getNome() + "</th>");
                saida.println("     <th>" + p.getFone() + "</th>");
                saida.println("     <th>" + p.getEmail() + "</th>");
                saida.println("     <th>" + p.getCidade().getNome() + "</th>");
                saida.println("     <th>" + p.getCidade().getEstado().getNome() + "</th>");
                saida.println("</tr>");
            }
        }


        saida.println("</table>");

        saida.println("</body>");

    }
}
