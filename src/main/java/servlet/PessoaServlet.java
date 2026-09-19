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
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class PessoaServlet extends HttpServlet {

    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private  List<Cidade> cidades = new ArrayList<Cidade>();
    public void init(){

        this.pessoas = new ArrayList<Pessoa>();

        Estado amazonas = new Estado();
        Cidade manaus = new Cidade();
        Cidade altazes = new Cidade();
        Cidade manaquiri = new Cidade();
        Cidade parentins = new Cidade();
        altazes.setNome("altazes");
        altazes.setEstado(amazonas);
        manaquiri.setNome("manaquiri");
        manaquiri.setEstado(amazonas);
        parentins.setNome("parentins");
        parentins.setEstado(amazonas);


        amazonas.setNome("Amazonas");
        amazonas.setSigla("Am");

        manaus.setNome("Manaus");
        manaus.setEstado(amazonas);
        cidades.add(manaus);
        cidades.add(manaquiri);
        cidades.add(parentins);
        cidades.add(altazes);
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




    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter saida = resp.getWriter();

        String acao = req.getParameter("acao");
        String salvar = req.getParameter("salvar");
        if(acao == null){
            acao = "listar";

        }



        String parametroNome = req.getParameter("nome");
        if(parametroNome == null){
            parametroNome = "";
        }



        String botaoSalvar = req.getParameter("salvar");
        if(botaoSalvar != null){
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String telefone = req.getParameter("telefone");
            String cidade = req.getParameter("cidade");
            String estado = req.getParameter("estado");

            Estado estado1= new Estado();
            estado1.setNome(estado);
            Cidade cidade1 = new Cidade();
            cidade1.setNome(cidade);
            cidade1.setEstado(estado1);

            Pessoa p = new Pessoa();
            p.setNome(nome);
            p.setEmail(email);
            p.setFone(telefone);
            p.setCidade(cidade1);
            pessoas.add(p);
            resp.sendRedirect("pessoa");
        }
        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("<meta charset=\"UTF-8\">");
        saida.println("</head>");


        saida.println("<body>");


        saida.println("<h1>Ola Ifam</h1>");
        saida.println("<p>-------------------------</p>");


        if(acao.equals("listar")) {


            saida.println("<a href='pessoa?acao=cadastrar'>Cadastrar Pessoa</a> ");

            saida.println("<form method='GET'  action='pessoa'>");
            saida.println("     <label for='parametroNome'>Nome</label>");
            saida.println("     <input type='text' id='parametroNome' name='nome' value=''>");
            saida.println("     <br></br>");
            saida.println("     <button type='submit' >Pesquisar</button>");

            saida.println("</form>");

            saida.println("<p></p>");

            saida.println("<table border = 1px>");


            saida.println("<tr>");
            saida.println("<th>Nome</th>");
            saida.println("<th>Fone</th>");
            saida.println("<th>Email</th>");
            saida.println("<th>Cidade</th>");
            saida.println("<th>Estado</th>");

            for (Pessoa p : pessoas) {
                if (p.getNome().toLowerCase().contains(parametroNome.toLowerCase())) {
                    saida.println("<tr>");
                    saida.println("     <td>" + p.getNome() + "</th>");
                    saida.println("     <td>" + p.getFone() + "</th>");
                    saida.println("     <td>" + p.getEmail() + "</th>");
                    saida.println("     <td>" + p.getCidade().getNome() + "</th>");
                    saida.println("     <td>" + p.getCidade().getEstado().getNome() + "</th>");
                    saida.println("</tr>");
                }
            }


            saida.println("</table>");
        }else if(acao.equals("cadastrar")){
            saida.println("<form method='get'  action='pessoa'>");
            saida.println("     <label for = 'filtroNome'>Nome: </label>");
            saida.println("     <input type='text' id='filtroNome' name='nome' value=''>");
            saida.println("     <br></br>");
            saida.println("     <label for = 'telefone'>Telefone: </label>");
            saida.println("     <input type='text' id='telefone' name='telefone' value=''>");
            saida.println("     <br></br>");
            saida.println("     <label for = 'email'>Email: </label>");
            saida.println("     <input type='text'  id='email' name='email' value=''>");
            saida.println("     <br></br>");

            saida.println("     <label for = 'cidade'>Cidade: </label>");
            saida.println("     <select id = 'cidade' name='cidade'>");
            for (Cidade cidade : cidades){
                saida.println("     <option value='"+cidade.getNome()+"'>"+cidade.getNome() +"/"+cidade.getEstado().getNome() +"</option>");
            }
            saida.println("     </select>");

            saida.println("     <input type='text'  id='imputCidade' name='imputCidade' value=''>");
            saida.println("     <br></br>");

            saida.println("     <button type='submit' name='salvar' value='precionado' >Salvar</button>");

            saida.println("<a href='pessoa?acao=listar'> cancelar</a> ");

            saida.println("</form>");

        }


        saida.println("</body>");
        saida.println("</html>");
    }
}
