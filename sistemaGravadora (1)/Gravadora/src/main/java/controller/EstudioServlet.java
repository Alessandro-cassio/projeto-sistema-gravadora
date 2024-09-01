package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Estudio;
import modelo.EstudioDAO;

@WebServlet("/estudioServlet")
public class EstudioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EstudioDAO estudioDAO;

    public void init() {
        estudioDAO = new EstudioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar"; // Padrão para listar estúdios
        }

        switch (action) {
            case "listar":
                listarEstudios(request, response);
                break;
            case "formularioAdicionar":
                exibirFormularioAdicionar(request, response);
                break;
            case "adicionar":
                adicionarEstudio(request, response);
                break;
            case "formularioEditar":
                exibirFormularioEditar(request, response);
                break;
            case "editar":
                editarEstudio(request, response);
                break;
            case "excluir":
                excluirEstudio(request, response);
                break;
            default:
                listarEstudios(request, response);
        }
    }

    private void listarEstudios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Estudio> listaEstudios = estudioDAO.selecionarTodosEstudios();
            request.setAttribute("listaEstudios", listaEstudios);
            request.getRequestDispatcher("/WEB-INF/listaEstudios.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar estudios", e);
        }
    }

    private void exibirFormularioAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/adicionarEstudio.jsp").forward(request, response);
    }

    private void adicionarEstudio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int numMusicasGravadas = Integer.parseInt(request.getParameter("numMusicasGravadas"));
        double taxaHoraEstudio = Double.parseDouble(request.getParameter("taxaHoraEstudio"));

        Estudio estudio = new Estudio(0, nome, numMusicasGravadas, taxaHoraEstudio);

        try {
            estudioDAO.adicionarEstudio(estudio);
            response.sendRedirect("estudioServlet?action=listar");
        } catch (SQLException e) {
            throw new ServletException("Erro ao adicionar estudio", e);
        }
    }

    private void exibirFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Estudio estudio = estudioDAO.selecionarEstudioPorId(id);
            request.setAttribute("estudio", estudio);
            request.getRequestDispatcher("/WEB-INF/editarEstudio.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao buscar estudio para edição", e);
        }
    }

    private void editarEstudio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int numMusicasGravadas = Integer.parseInt(request.getParameter("numMusicasGravadas"));
        double taxaHoraEstudio = Double.parseDouble(request.getParameter("taxaHoraEstudio"));

        Estudio estudio = new Estudio(id, nome, numMusicasGravadas, taxaHoraEstudio);

        try {
            estudioDAO.atualizarEstudio(estudio);
            response.sendRedirect("estudioServlet?action=listar");
        } catch (SQLException e) {
            throw new ServletException("Erro ao atualizar estudio", e);
        }
    }

    private void excluirEstudio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            estudioDAO.excluirEstudio(id);
            response.sendRedirect("estudioServlet?action=listar");
        } catch (SQLException e) {
            throw new ServletException("Erro ao excluir estudio", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
