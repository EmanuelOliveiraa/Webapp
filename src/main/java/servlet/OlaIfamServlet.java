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

public class OlaIfamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter saida = resp.getWriter();

        Pessoa pessoa1 = new Pessoa();
        Estado amazonas = new Estado();
        Cidade manaus = new Cidade();

        amazonas.setNome("Amazonas");
        amazonas.setSigla("Am");

        manaus.setNome("Manaus");
        manaus.setEstado(amazonas);

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
        saida.println("<h1> Ola IFAM</h>");
        saida.println("<p>Pessoa: " + pessoa1.getNome() + "</p>");
        saida.println("<p>Email: " + pessoa1.getEmail() + "</p>");
        saida.println("<p>Fone: " + pessoa1.getFone() + "</p>");
        saida.println("<p>Cidade: " + pessoa1.getCidade() + "</p>");
        saida.println("<p>Estado: " + pessoa1.getCidade().getEstado().getNome() + "</p>");
        saida.println("</body>");

    }
}
